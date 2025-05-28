package com.phobos.goldentrianglewebsitebackend.Controller;


import com.phobos.goldentrianglewebsitebackend.Model.Genus;
import com.phobos.goldentrianglewebsitebackend.Model.Relationship;
import com.phobos.goldentrianglewebsitebackend.Model.Species;
import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsEdgeInfo;
import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsInfo_Node;
import com.phobos.goldentrianglewebsitebackend.Model.dto.ListInfo;
import com.phobos.goldentrianglewebsitebackend.Service.GenusService;
import com.phobos.goldentrianglewebsitebackend.Service.ListInfoService;
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
    private final ListInfoService listInfoService;


    @Autowired
    public ChartsController(SpeciesService speciesService, GenusService genusService, RelationshipService relationshipService, ListInfoService listInfoService) {
        this.speciesService = speciesService;
        this.genusService = genusService;
        this.relationshipService = relationshipService;
        this.listInfoService = listInfoService;
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
            node.setType(plant.getTaxon_rank());
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
            node.setType(genus.getTaxon_rank());
            nodes.add(node);
        }
        return nodes;
    }

    // 查找属节点
    @RequestMapping("/findNodesByAreaInNeed")
    public List<ChartsInfo_Node> findNodesByAreaInNeed(String area){

        List<Genus> genus_list = genusService.findGenusInNeed();
        List<ChartsInfo_Node> nodes = new ArrayList<>();
        List<String> genus_name_list = new ArrayList<>();
        for (Genus genus : genus_list) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            genus_name_list.add(genus.getTaxon_name());
            node.setId(String.valueOf(genus.getNode_id()));
            node.setName(genus.getTaxon_name());
            node.setValue(genus.getCh_name());
            node.setType(genus.getTaxon_rank());
            nodes.add(node);
        }
        List<Species> species_list = new ArrayList<>();
        for (String genus : genus_name_list) {
            species_list.addAll(speciesService.findSpeciesByGenusAndArea(genus,area));
        }
        System.out.println(species_list);
        for (Species species : species_list) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setId(String.valueOf(species.getNode_id()));
            node.setName(species.getTaxon_name());
            node.setValue(species.getCh_name());
            node.setType(species.getTaxon_rank());
            nodes.add(node);
        }
        return nodes;
    }

    @RequestMapping("/findCNodesByGenus")
    List<ChartsInfo_Node> findNodesByGenus(String genus){
        List<ChartsInfo_Node> nodes = new ArrayList<>();
        List<Genus> genus_list = genusService.findGenusByTaxonName(genus);
        for (Genus genus1 : genus_list) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setId(String.valueOf(genus1.getNode_id()));
            node.setName(genus1.getTaxon_name());
            node.setValue(genus1.getCh_name());
            node.setType(genus1.getTaxon_rank());
            nodes.add(node);
        }
        List<Species> plants = speciesService.getSpeciesByGenusContains(genus);
        for (Species plant : plants) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setValue(plant.getCh_name());
            node.setName(plant.getTaxon_name());
            node.setId(String.valueOf(plant.getNode_id()));
            nodes.add(node);
        }
        return nodes;
    }

    @RequestMapping("/findCEdgesByGenus")
    List<ChartsEdgeInfo> findCEdgesByGenus(long genus_id){
        List<ChartsEdgeInfo> edges = new ArrayList<>();
        List<Relationship> relationships = relationshipService.findRelationshipByEndNodeID(genus_id);
        for (Relationship relationship : relationships) {
            ChartsEdgeInfo edge = new ChartsEdgeInfo();
            edge.setSource(String.valueOf(relationship.getStartNodeId()));
            edge.setTarget(String.valueOf(relationship.getEndNodeId()));
            edge.setValue(relationship.getType());
            edges.add(edge);
        }
        return edges;
    }


    //分页查找植物节点
    @RequestMapping("/findNodesWithPages")
    public List<ListInfo> findNodesWithPages(int page, int size){
        return listInfoService.findListInfoWithPages(page, size);
    }

    @RequestMapping("/findNodesByChNameContainsWithPage")
    public List<ListInfo> findNodesByCh_nameContainsWithPage(String ch_name, int page, int size){
        return listInfoService.findListInfoByChNameContainsWithPage(ch_name, page, size);
    }

    @RequestMapping("/findNodesByTaxonNameContainsWithPage")
    public List<ListInfo> findNodesByTaxonNameContainsWithPage(String taxon_name, int page, int size){
        return listInfoService.findListInfoByTaxonNameContainsWithPage(taxon_name, page, size);
    }
    @RequestMapping("/findNodesByAreaWithPage")
    public List<ListInfo> findNodesByAreaWithPage(String area, int page, int size){
        return listInfoService.findListInfoByAreaWithPage(area, page, size);
    }

    // 统计搜索数据
    @RequestMapping("/getCounts")
    public int[] getCounts(){
        return new int[]{0,0,0,0,0,0,0,0,0,0};
    }
    @RequestMapping("/getAllListInfoCounts")
    public int getAllCounts(){
        return listInfoService.countAllListInfo();
    }
    @RequestMapping("/getListInfoCountsByChNameContains")
    public int getCountsByChNameContains(String ch_name){
        return listInfoService.countListInfoByChNameContains(ch_name);
    }
    @RequestMapping("/getListInfoCountsByTaxonNameContains")
    public int getCountsByTaxonNameContains(String taxon_name){
        return listInfoService.countListInfoByTaxonNameContains(taxon_name);
    }
    @RequestMapping("/getListInfoCountsByArea")
    public int getCountsByArea(String area){
        return listInfoService.countListInfoByArea(area);
    }

}
