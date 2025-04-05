package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.Plant;

import java.util.List;

public interface PlantService {
    List<Plant> findAll();
    List<Plant> getPlantByNameContains(String name);
    List<Plant> getPlantByRegionContains(String region);
    List<Plant> getPlantByCountryContains(String country);
    List<Plant> getPlantByFamilyContains(String family);
}
