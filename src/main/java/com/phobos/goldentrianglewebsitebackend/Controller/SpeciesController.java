package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.Species;
import com.phobos.goldentrianglewebsitebackend.Service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpeciesController {
    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @RequestMapping("/findAllSpecies")
    public List<Species> getAllSpecies() {
        return speciesService.findAllSpecies();
    }

    @RequestMapping("/getSpeciesByTaxonNameContains")
    public List<Species> getSpeciesByTaxonNameContains(String name) {
        return speciesService.getSpeciesByTaxonNameContains(name);
    }
    @RequestMapping("/getSpeciesByAreaContains")
    public List<Species> getSpeciesByAreaContains(String area) {
        return speciesService.getSpeciesByAreaContains(area);
    }
    @RequestMapping("/getSpeciesByFamilyContains")
    public List<Species> getSpeciesByFamilyContains(String family) {
        return speciesService.getSpeciesByFamilyContains(family);
    }
    @RequestMapping("/getSpeciesByGenusContains")
    public List<Species> getSpeciesByGenusContains(String genus) {
        return speciesService.getSpeciesByGenusContains(genus);
    }
    @RequestMapping("/getSpeciesByCh_nameContains")
    public List<Species> getSpeciesByCh_nameContains(String ch_name) {
        return speciesService.getSpeciesByCh_nameContains(ch_name);
    }
    @RequestMapping("/findSpeciesByNodeId")
    public List<Species> findSpeciesByNodeId(long id) {
        return speciesService.findSpeciesByNodeId(id);
    }
    @RequestMapping("/findSpeciesByPlantId")
    public List<Species> findSpeciesByPlantId(int plant_id) {
        return speciesService.findSpeciesByPlantId(plant_id);
    }
    @RequestMapping("/findSpeciesByArea")
    public List<Species> findSpeciesByArea(String area) {
        return speciesService.findSpeciesByArea(area);
    }
}
