package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsInfo_Node;
import com.phobos.goldentrianglewebsitebackend.Model.Plant;
import com.phobos.goldentrianglewebsitebackend.Service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlantController {
    // 处理植物相关请求的控制器
    private final PlantService plantService;
    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // 查询所有植物
    @RequestMapping("/findAll")
    public List<Plant> findAllPlants(){
        return plantService.findAll();
    }

    @RequestMapping("/getPlantByNameContains")
    public List<Plant> getPlantsByNameContains(String name) {
        return plantService.getPlantByNameContains(name);
    }
    @RequestMapping("/getPlantByRegionContains")
    public List<Plant> getPlantByRegionContains(String region) {
        return plantService.getPlantByRegionContains(region);
    }
    @RequestMapping("/getPlantByCountryContains")
    public List<Plant> getPlantByCountryContains(String country) {
        return plantService.getPlantByCountryContains(country);
    }
    @RequestMapping("/getPlantByFamilyContains")
    public List<Plant> getPlantByFamilyContains(String family) {
        return plantService.getPlantByFamilyContains(family);
    }

    @RequestMapping("/createPlant")
    public void createPlant(String Taxon, String Family, String region, String country) {
        plantService.createPlant(Taxon, Family, region, country);
    }
    @RequestMapping("/deletePlant")
    public void deletePlant(long id) {
        plantService.deletePlant(id);
    }
    @RequestMapping("/updatePlant")
    public void updatePlant(long id, String Taxon, String Family, String region, String country) {
        plantService.updatePlant(id, Taxon, Family, region, country);
    }
    @RequestMapping("/findById")
    public List<Plant> findById(long id) {
        return plantService.findById(id);
    }
    @RequestMapping("/Chart")
    public List<ChartsInfo_Node> getChartsInfo() {
        List<Plant> Plants = plantService.findAll();
        List<ChartsInfo_Node> chartsInfoNodes = new ArrayList<>();
        if (!Plants.isEmpty()) {
            for (Plant plant : Plants) {
                ChartsInfo_Node chartsInfoNode = new ChartsInfo_Node();
                chartsInfoNode.setId(plant.getId());
                chartsInfoNode.setName(plant.getTaxon());
                chartsInfoNode.setValue(plant.getFamily());
                chartsInfoNodes.add(chartsInfoNode);
            }
        }
        return chartsInfoNodes;
    }


}
