package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.Plant;
import com.phobos.goldentrianglewebsitebackend.Service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlantController {
    private final PlantService plantService;
    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }


    @RequestMapping("/findAll")
    public List<Plant> findAllPlants(){
        System.out.println(plantService.findAll().toString());
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

}
