package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.Species;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepo extends Neo4jRepository<Species, Long> {

    // 查找所有植物节点
    @Query("MATCH (m:species) RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> findAllSpecies();

    // 通过植物学名模糊查找植物节点
    @Query("Match (m:species) Where m.taxon_name contains $name RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> getSpeciesByTaxonNameContains(String taxon_name);

    // 通过分布地区模糊查找植物节点
    @Query("Match (m:species) Where m.area contains $area RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> getSpeciesByAreaContains(String area);

    // 通过中文名模糊查找植物节点
    @Query("Match (m:species) Where m.ch_name contains $ch_name RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> getSpeciesByCh_nameContains(String ch_name);

    // 通过科名模糊查找植物节点
    @Query("Match (m:species) Where m.Family contains $family RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> getSpeciesByFamilyContains(String family);

    // 通过属名模糊查找植物节点
    @Query("Match (m:species) Where m.genus contains $genus RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> getSpeciesByGenusContains(String genus);

    // 通过id查找植物节点
    @Query("Match (m:species) Where ID(m) = $id RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date")
    List<Species> findSpeciesByNodeId(long id);

    // 通过植物id查找植物节点
    @Query("Match (m:species) Where m.plant_id = $plant_id RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> findSpeciesByPlantId(int plant_id);

    // 通过分布地区查找植物节点
    @Query("Match (m:species) Where m.area = $area RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> findSpeciesByArea(String area);

    @Query("Match (m:species) Where m.publish_date = $pub_date RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> findSpeciesByPubDate(String pub_date);

    @Query("Match (m:species) Where m.genus = $genus RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.genus as genus" +
            ",m.area as area" +
            ",m.publish_date as publish_date" +
            ",m.ch_name as ch_name")
    List<Species> findSpeciesByGenus(String genus);

    /**
     * 创建植物节点
     */
    @Query("CREATE (n:species {plant_id: $.plant_id" +
            ",taxon_rank: $taxon_rank" +
            ",taxon_name: $taxon_name " +
            ",family: $Family " +
            ",genus: $genus " +
            ",area: $area" +
            ",ch_name: $ch_name" +
            ",publish_date: $publish_date})" )
    void createSpecies(int plant_id
            , String taxon_rank
            , String taxon_name
            , String Family
            , String area
            , String genus
            , String ch_name
            , int publish_date);

    @Query("MATCH (n:species) where ID(n)=$node_id DELETE n")
    void deleteSpecies(long node_id);

    @Query("MATCH (n:species) where ID(n)=$id SET n.taxon_name = $taxon_name" +
            ", n.taxon_rank = $taxon_rank" +
            ", n.family = $Family" +
            ", n.area = $area" +
            ", n.ch_name = $ch_name" +
            ", n.genus = $genus" +
            ", n.publish_date = $publish_date")
    void updateSpecies(long id, String taxon_rank,String taxon_name, String Family, String genus, String area, String ch_name,int publish_date);

}
