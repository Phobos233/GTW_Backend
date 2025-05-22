package com.phobos.goldentrianglewebsitebackend.Controller;


import com.phobos.goldentrianglewebsitebackend.Model.Genus;
import com.phobos.goldentrianglewebsitebackend.Model.Relationship;
import com.phobos.goldentrianglewebsitebackend.Model.Species;
import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsEdgeInfo;
import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsInfo_Node;
import com.phobos.goldentrianglewebsitebackend.Repository.GenusRepo;
import com.phobos.goldentrianglewebsitebackend.Service.GenusService;
import com.phobos.goldentrianglewebsitebackend.Service.RelationshipService;
import com.phobos.goldentrianglewebsitebackend.Service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class ChartsController {

    private final SpeciesService speciesService;
    private final GenusService genusService;
    private final RelationshipService relationshipService;
    private final GenusRepo genusRepo;

    @Autowired
    public ChartsController(SpeciesService speciesService, GenusService genusService, RelationshipService relationshipService, GenusRepo genusRepo) {
        this.speciesService = speciesService;
        this.genusService = genusService;
        this.relationshipService = relationshipService;
        this.genusRepo = genusRepo;
    }


    // 处理与图表相关的请求
    // 这里可以添加处理图表数据的请求方法
    // 例如，获取某个物种的数量、分布等信息
    // 具体实现根据需求来定

    // 示例方法
    // @RequestMapping("/getSpeciesCount")
    // public int getSpeciesCount() {
    //     return speciesService.getSpeciesCount();
    // }

    @RequestMapping("/findAllNodes")
    public List<ChartsInfo_Node> findAllNodes(){
        List<ChartsInfo_Node> nodes = new ArrayList<>();
        List<Species> plants = speciesService.findAllSpecies();

        List<Genus> genus_list = genusService.findAllGenus();
        for (Species plant : plants) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setValue(plant.getCh_name());
            node.setName(plant.getTaxon_name());
            node.setId(String.valueOf(plant.getNode_id()));
            nodes.add(node);
        }
        for (Genus genus : genus_list) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setId(String.valueOf(genus.getNode_id()));
            node.setName(genus.getTaxon_name());
            node.setValue(genus.getCh_name());
            nodes.add(node);
        }
        return nodes;
    }

    @RequestMapping("/findAllEdges")
    public List<ChartsEdgeInfo> findAllEdges(){
        List<ChartsEdgeInfo> edges = new ArrayList<>();
        List<Relationship> relationships = relationshipService.findAllRelationships();
        for (Relationship relationship : relationships) {
            ChartsEdgeInfo edge = new ChartsEdgeInfo();
            edge.setSource(String.valueOf(relationship.getStartNodeId()));
            edge.setTarget(String.valueOf(relationship.getEndNodeId()));
            edge.setValue(relationship.getType());
            edges.add(edge);
        }
        return edges;
    }

    // 地区信息查找植物节点
    @RequestMapping("/findNodesByArea")
    public List<ChartsInfo_Node> findNodesByArea(String area){
        //查找植物节点
        List<ChartsInfo_Node> nodes = new ArrayList<>();
        List<Species> plants = speciesService.getSpeciesByAreaContains(area);
        List<String> genus_list = new ArrayList<>();
        for (Species plant : plants) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setValue(plant.getCh_name());
            node.setName(plant.getTaxon_name());
            node.setId(String.valueOf(plant.getNode_id()));
            genus_list.add(plant.getGenus());
            nodes.add(node);
        }
        // 去重
        Set<String> genus_set = new HashSet<>(genus_list);
        List<String> new_genus_list = new ArrayList<>(genus_set);
        // 查找属节点
        List<Genus> genus_result = genusService.findGenusByTaxonName(new_genus_list);

        for (Genus genus : genus_result) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setId(String.valueOf(genus.getNode_id()));
            node.setName(genus.getTaxon_name());
            node.setValue(genus.getCh_name());
            nodes.add(node);
        }
        return nodes;
    }

    @RequestMapping("/getCounts")
    public int[] getCounts(){
        return new int[]{0,0,0,0,0,0,0,0,0,0};
    }



}
