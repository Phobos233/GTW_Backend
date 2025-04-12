package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.Plant;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepo extends Neo4jRepository<Plant, Long> {
    @Query("MATCH (m:plant) RETURN ID(m) as id,Labels(m) as label,m.Taxon as Taxon,m.Family as Family,m.region as Region,m.country as Country")
    public List<Plant> findAll();

    @Query("Match (m) Where m.Taxon contains $name return ID(m) as id,Labels(m) as label,m.Taxon as Taxon,m.Family as Family,m.region as Region,m.country as Country")
    public List<Plant> getPlantByNameContains(String name);

    @Query("Match (m) Where m.region contains $region return ID(m) as id,Labels(m) as label,m.Taxon as Taxon,m.Family as Family,m.region as Region,m.country as Country")
    public List<Plant> getPlantByRegionContains(String region);
    @Query("Match (m) Where m.country contains $country return ID(m) as id,Labels(m) as label,m.Taxon as Taxon,m.Family as Family,m.region as Region,m.country as Country")
    public List<Plant> getPlantByCountryContains(String country);
    @Query("Match (m) Where m.Family contains $family return ID(m) as id,Labels(m) as label,m.Taxon as Taxon,m.Family as Family,m.region as Region,m.country as Country")
    public List<Plant> getPlantByFamilyContains(String family);

    // 通过id查找植物节点
    @Query("Match (m:plant) Where ID(m) = $id return ID(m) as id,Labels(m) as label,m.Taxon as Taxon,m.Family as Family,m.region as Region,m.country as Country")
    List<Plant> findById(long id);

    @Query("CREATE (n:plant {Taxon: $Taxon, Family: $Family , region: $region,country: $country})")
    public void createPlant(String Taxon, String Family, String region, String country);
    @Query("MATCH (n:plant) where ID(n)=$id DELETE n")
    public void deletePlant(long id);

    @Query("MATCH (n:plant) where ID(n)=$id SET n.Taxon = $Taxon, n.Family = $Family, n.region = $region, n.country = $country")
    public void updatePlant(long id, String Taxon, String Family, String region, String country);


}
