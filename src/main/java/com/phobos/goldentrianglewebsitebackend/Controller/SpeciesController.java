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

    //模糊查找
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

    //精确查找
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
    @RequestMapping("/findSpeciesByPubDate")
    public List<Species> findSpeciesByPubDate(String pub_date) {
        return speciesService.findSpeciesByPubDate(pub_date);
    }
    @RequestMapping("/findSpeciesByGenus")
    public List<Species> findSpeciesByGenus(String genus) {
        return speciesService.findSpeciesByGenus(genus);
    }

    //分页查找
    @RequestMapping("/findAllSpeciesWithPage")
    public List<Species> findAllSpeciesWithPage(int page, int size) {
        return speciesService.findAllSpeciesWithPage(page, size);
    }

    //增删改
    @RequestMapping("/createSpecies")
    public void createSpecies(int plant_id, String taxon_rank, String taxon_name, String Family, String area, String genus, String ch_name, int publish_date) {
        speciesService.createSpecies(plant_id, taxon_rank, taxon_name, Family, area, genus, ch_name, publish_date);
    }
    @RequestMapping("/deleteSpecies")
    public void deleteSpecies(long node_id) {
        speciesService.deleteSpecies(node_id);
    }
    @RequestMapping("/updateSpecies")
    public void updateSpecies(long id, String taxon_rank, String taxon_name, String Family, String genus, String area, String ch_name, int publish_date) {
        speciesService.updateSpecies(id, taxon_rank, taxon_name, Family, genus, area, ch_name, publish_date);
    }

    //计数
    @RequestMapping("/countSpeciesByGenus")
    public int countSpeciesByGenus(String genus) {
        return speciesService.countSpeciesByGenus(genus);
    }
    @RequestMapping("/countSpeciesByArea")
    public int countSpeciesByArea(String area) {
        return speciesService.countSpeciesByArea(area);
    }
    @RequestMapping("/countSpeciesByFamily")
    public int countSpeciesByFamily(String family) {
        return speciesService.countSpeciesByFamily(family);
    }
    @RequestMapping("/countSpeciesByPub_date")
    public int countSpeciesByPub_date(int pub_date) {
        return speciesService.countSpeciesByPub_date(pub_date);
    }

    @RequestMapping("/countAllSpecies")
    public int countAllSpecies() {
        return speciesService.countAllSpecies();
    }
}
