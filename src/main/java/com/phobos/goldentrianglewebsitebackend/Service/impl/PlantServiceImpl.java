package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.Plant;
import com.phobos.goldentrianglewebsitebackend.Repository.PlantRepo;
import com.phobos.goldentrianglewebsitebackend.Service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    private final PlantRepo plantRepo;

    @Autowired
    public PlantServiceImpl(PlantRepo plantRepo) {
        this.plantRepo = plantRepo;
    }



    @Override
    public List<Plant> findAll() {
        System.out.println(plantRepo.findAll());
        return plantRepo.findAll();
    }

    @Override
    public List<Plant> getPlantByNameContains(String name) {
        return plantRepo.getPlantByNameContains(name);
    }

    @Override
    public List<Plant> getPlantByRegionContains(String region) {
        return plantRepo.getPlantByRegionContains(region);
    }

    @Override
    public List<Plant> getPlantByCountryContains(String country) {
        return plantRepo.getPlantByCountryContains(country);
    }

    @Override
    public List<Plant> getPlantByFamilyContains(String family) {
        return plantRepo.getPlantByFamilyContains(family);
    }

    @Override
    public void createPlant(String Taxon, String Family, String region, String country) {
        plantRepo.createPlant(Taxon, Family, region, country);
    }

    @Override
    public void deletePlant(long id) {
        plantRepo.deletePlant(id);
    }

    @Override
    public void updatePlant(long id, String Taxon, String Family, String region, String country) {
        plantRepo.updatePlant(id, Taxon, Family, region, country);
    }

    @Override
    public List<Plant> findById(long id) {
        return plantRepo.findById(id);
    }
}
