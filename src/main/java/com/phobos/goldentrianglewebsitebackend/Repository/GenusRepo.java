package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.Genus;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenusRepo extends Neo4jRepository<Genus, Long> {

    // 查找所有植物节点
    @Query("MATCH (m:genus) RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name" )
    List<Genus> findAllGenus();

    // 通过植物学名模糊查找属节点
    @Query("Match (m:genus) Where m.taxon_name contains $name RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> getGenusByTaxonNameContains(String taxon_name);

    // 通过中文名模糊查找植物节点
    @Query("Match (m:genus) Where m.ch_name contains $ch_name RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> getGenusByCh_nameContains(String ch_name);

    // 通过科名模糊查找属节点
    @Query("Match (m:genus) Where m.Family contains $family RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> getGenusByFamilyContains(String family);

    // 通过节点id查找属节点
    @Query("Match (m:genus) Where ID(m) = $id RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> findGenusByNodeId(long id);

    // 通过属id查找属节点
    @Query("Match (m:genus) Where m.plant_id = $plant_id RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> findGenusByPlantId(int plant_id);

    // 通过科名查找属节点
    @Query("Match (m:genus) Where m.Family = $family RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> findGenusByFamily(String family);

    // 通过属名查找属节点

    @Query("Match (m:genus) Where m.taxon_name = $TaxonName RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name")
    List<Genus> findGenusByTaxonName(String TaxonName);

    @Query("MATCH (m)-[r]-() WITH m, COUNT(DISTINCT r) AS rel_count WHERE rel_count > 5 RETURN ID(m) As node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name"+
            " Order BY rand() Limit 10")
    List<Genus> findGenusInNeed();

    // 分页查询属节点
    @Query("MATCH (m:genus) RETURN ID(m) as node_id" +
            ",m.plant_id as plant_id" +
            ",m.taxon_name as taxon_name" +
            ",m.taxon_rank as taxon_rank" +
            ",m.family as family" +
            ",m.ch_name as ch_name" +
            " SKIP $start LIMIT $size")
    List<Genus> findAllGenusWithPage(int start, int size);

    /**
     * 创建属节点
     */
    @Query("CREATE (n:Genus {plant_id: $.plant_id" +
            ",taxon_rank: $taxon_rank" +
            ",taxon_name: $taxon_name " +
            ",family: $Family " +
            ",ch_name: $ch_name" +
            "}) " )
    void createGenus(int plant_id, String taxon_rank, String taxon_name, String Family, String ch_name);

    @Query("MATCH (n:Genus) where ID(n)=$node_id DELETE n")
    void deleteGenus(long node_id);

    @Query("MATCH (n:Genus) where ID(n)=$node_id SET n.taxon_name = $taxon_name" +
            ", n.Family = $Family, n.taxon_rank = $taxon_rank, n.ch_name = $ch_name")
    void updateGenus(long node_id, String taxon_name, String Family, String taxon_rank, String ch_name);

    @Query("Match (m:genus) Where m.Family = $Family RETURN count(m)")
    int countGenusByFamily(String Family);

    @Query("Match (m:genus) RETURN count(m)")
    int countAllGenus();
}
