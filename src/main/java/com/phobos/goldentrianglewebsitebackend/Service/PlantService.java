package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.Plant;

import java.util.List;

public interface PlantService {
    List<Plant> findAll();
    List<Plant> getPlantByNameContains(String name);
    List<Plant> getPlantByRegionContains(String region);
    List<Plant> getPlantByCountryContains(String country);
    List<Plant> getPlantByFamilyContains(String family);
    void createPlant(String Taxon, String Family, String region, String country);
    void deletePlant(long id);
    void updatePlant(long id, String Taxon, String Family, String region, String country);
    List<Plant> findById(long id);
}
