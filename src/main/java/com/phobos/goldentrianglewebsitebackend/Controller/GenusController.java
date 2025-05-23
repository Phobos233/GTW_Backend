package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.Genus;
import com.phobos.goldentrianglewebsitebackend.Service.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenusController {

    private final GenusService genusService;

    @Autowired
    public GenusController(GenusService genusService) {
        this.genusService = genusService;
    }

    // 处理与属相关的请求

    @RequestMapping("/findAllGenus")
    public List<Genus> findAllGenus() {
        return genusService.findAllGenus();
    }

    @RequestMapping("/getGenusByTaxonNameContains")
    public List<Genus> getGenusByTaxonNameContains(String name) {
        return genusService.getGenusByTaxonNameContains(name);
    }

    @RequestMapping("/getGenusByFamilyContains")
    public List<Genus> getGenusByFamilyContains(String family) {
        return genusService.getGenusByFamilyContains(family);
    }

    @RequestMapping("/getGenusByCh_nameContains")
    public List<Genus> getGenusByCh_nameContains(String ch_name) {
        return genusService.getGenusByCh_nameContains(ch_name);
    }

    @RequestMapping("/findGenusByNodeId")
    public List<Genus> findGenusByNodeId(long id) {
        return genusService.findGenusByNodeId(id);
    }
    @RequestMapping("/findGenusByPlantId")
    public List<Genus> findGenusByPlantId(int plant_id) {
        return genusService.findGenusByPlantId(plant_id);
    }
    @RequestMapping("/findGenusByFamily")
    public List<Genus> findGenusByFamily(String family) {
        return genusService.findGenusByFamily(family);
    }

    @RequestMapping("/findAllGenusWithPage")
    public List<Genus> findAllGenusWithPage(int page, int size) {
        return genusService.findAllGenusWithPage(page, size);
    }

    @RequestMapping("/createGenus")
    public void createGenus(int plant_id, String taxon_rank, String taxon_name, String Family, String ch_name) {
        genusService.createGenus(plant_id, taxon_rank, taxon_name, Family, ch_name);
    }
    @RequestMapping("/deleteGenus")
    public void deleteGenus(long node_id) {
        genusService.deleteGenus(node_id);
    }
    @RequestMapping("/updateGenus")
    public void updateGenus(long node_id, String taxon_name, String Family, String taxon_rank, String ch_name) {
        genusService.updateGenus(node_id, taxon_name, Family, taxon_rank, ch_name);
    }

    @RequestMapping("/countGenusByFamily")
    public int countGenusByFamily(String family) {
        return genusService.countGenusByFamily(family);
    }

    @RequestMapping("/countAllGenus")
    public int countAllGenus() {
        return genusService.countAllGenus();
    }

}
