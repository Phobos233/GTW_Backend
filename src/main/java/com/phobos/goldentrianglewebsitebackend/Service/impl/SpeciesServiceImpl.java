package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.Species;
import com.phobos.goldentrianglewebsitebackend.Repository.SpeciesRepo;
import com.phobos.goldentrianglewebsitebackend.Service.SpeciesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepo speciesRepo;

    public SpeciesServiceImpl(SpeciesRepo speciesRepo) {
        this.speciesRepo = speciesRepo;
    }


    @Override
    public List<Species> findAllSpecies() {
        return speciesRepo.findAllSpecies();
    }

    @Override
    public List<Species> getSpeciesByTaxonNameContains(String name) {
        return speciesRepo.getSpeciesByTaxonNameContains(name);
    }

    @Override
    public List<Species> getSpeciesByAreaContains(String area) {
        return speciesRepo.getSpeciesByAreaContains(area);
    }

    @Override
    public List<Species> getSpeciesByFamilyContains(String family) {
        return speciesRepo.getSpeciesByFamilyContains(family);
    }

    @Override
    public List<Species> getSpeciesByGenusContains(String genus) {
        return speciesRepo.getSpeciesByGenusContains(genus);
    }

    @Override
    public List<Species> getSpeciesByCh_nameContains(String ch_name) {
        return speciesRepo.getSpeciesByCh_nameContains(ch_name);
    }

    @Override
    public List<Species> findSpeciesByNodeId(long id) {
        return speciesRepo.findSpeciesByNodeId(id);
    }

    @Override
    public List<Species> findSpeciesByPlantId(int plant_id) {
        return speciesRepo.findSpeciesByPlantId(plant_id);
    }

    @Override
    public List<Species> findSpeciesByArea(String area) {
        return speciesRepo.findSpeciesByArea(area);
    }

    @Override
    public List<Species> findSpeciesByPubDate(String pub_date) {
        return speciesRepo.findSpeciesByPubDate(pub_date);
    }

    @Override
    public List<Species> findSpeciesByGenus(String genus) {
        return speciesRepo.findSpeciesByGenus(genus);
    }

    @Override
    public void createSpecies(int plant_id, String taxon_rank, String taxon_name, String Family, String area, String genus, String ch_name, int publish_date) {
        speciesRepo.createSpecies(plant_id, taxon_rank, taxon_name, Family, area, genus, ch_name, publish_date);
    }

    @Override
    public void deleteSpecies(long node_id) {
        speciesRepo.deleteSpecies(node_id);
    }

    @Override
    public void updateSpecies(long id, String taxon_rank, String taxon_name, String Family, String genus, String area, String ch_name, int publish_date) {
        speciesRepo.updateSpecies(id, taxon_rank, taxon_name, Family, genus, area, ch_name, publish_date);
    }
}
