package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.Genus;
import com.phobos.goldentrianglewebsitebackend.Repository.GenusRepo;
import com.phobos.goldentrianglewebsitebackend.Service.GenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenusServiceImpl implements GenusService {

    private final GenusRepo genusRepo;

    @Autowired
    public GenusServiceImpl(GenusRepo genusRepo) {
        this.genusRepo = genusRepo;
    }

    @Override
    public List<Genus> findAllGenus() {
        return genusRepo.findAllGenus();
    }

    @Override
    public List<Genus> getGenusByTaxonNameContains(String name) {
        return genusRepo.getGenusByTaxonNameContains(name);
    }

    @Override
    public List<Genus> getGenusByFamilyContains(String family) {
        return genusRepo.getGenusByFamilyContains(family);
    }

    @Override
    public List<Genus> getGenusByCh_nameContains(String ch_name) {
        return genusRepo.getGenusByCh_nameContains(ch_name);
    }

    @Override
    public List<Genus> findGenusByNodeId(long id) {
        return genusRepo.findGenusByNodeId(id);
    }

    @Override
    public List<Genus> findGenusByPlantId(int plant_id) {
        return genusRepo.findGenusByPlantId(plant_id);
    }

    @Override
    public List<Genus> findGenusByFamily(String family) {
        return genusRepo.findGenusByFamily(family);
    }

    @Override
    public List<Genus> findGenusByTaxonName(String taxon_name) {
        return genusRepo.findGenusByTaxonName(taxon_name);
    }

    @Override
    public List<Genus> findGenusByTaxonName(List<String> taxon_names) {
        List<Genus> genus_result = new ArrayList<>();
        for (String genus : taxon_names) {
            genus_result.addAll(genusRepo.findGenusByTaxonName(genus));
        }
        return genus_result;
    }

    @Override
    public List<Genus> findGenusInNeed() {
        return genusRepo.findGenusInNeed();
    }

    @Override
    public List<Genus> findAllGenusWithPage(int page, int size) {
        int start = (page - 1) * size;
        return genusRepo.findAllGenusWithPage(start, size);
    }

    @Override
    public void createGenus(int plant_id, String taxon_rank, String taxon_name, String Family, String ch_name) {
        genusRepo.createGenus(plant_id, taxon_rank, taxon_name, Family, ch_name);
    }

    @Override
    public void deleteGenus(long node_id) {
        genusRepo.deleteGenus(node_id);
    }

    @Override
    public void updateGenus(long node_id, String taxon_name, String Family, String taxon_rank, String ch_name) {
        genusRepo.updateGenus(node_id, taxon_name, Family, taxon_rank, ch_name);
    }

    @Override
    public int countGenusByFamily(String family) {
        return genusRepo.countGenusByFamily(family);
    }

    @Override
    public int countAllGenus() {
        return genusRepo.countAllGenus();
    }
}
