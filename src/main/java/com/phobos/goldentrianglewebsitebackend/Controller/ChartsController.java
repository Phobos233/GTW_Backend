package com.phobos.goldentrianglewebsitebackend.Controller;


import com.phobos.goldentrianglewebsitebackend.Model.Genus;
import com.phobos.goldentrianglewebsitebackend.Model.Species;
import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsInfo_Node;
import com.phobos.goldentrianglewebsitebackend.Service.GenusService;
import com.phobos.goldentrianglewebsitebackend.Service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChartsController {

    private final SpeciesService speciesService;
    private final GenusService genusService;

    @Autowired
    public ChartsController(SpeciesService speciesService, GenusService genusService) {
        this.speciesService = speciesService;
        this.genusService = genusService;
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
        List<ChartsInfo_Node> nodes = new ArrayList<ChartsInfo_Node>();
        List<Species> plants = speciesService.findAllSpecies();
        List<Genus> genus_list = genusService.findAllGenus();
        for (Species plant : plants) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setValue(plant.getCh_name());
            node.setName(plant.getTaxon_name());
            node.setId(plant.getNode_id());
            nodes.add(node);
        }
        for (Genus genus : genus_list) {
            ChartsInfo_Node node = new ChartsInfo_Node();
            node.setId(genus.getNode_id());
            node.setName(genus.getTaxon_name());
            node.setValue(genus.getCh_name());
            nodes.add(node);
        }
        return nodes;
    }



}
