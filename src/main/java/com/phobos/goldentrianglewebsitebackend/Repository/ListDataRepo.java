package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.dto.ListInfo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListDataRepo extends Neo4jRepository<ListInfo, Long> {
    // This interface is intentionally left blank. It extends Neo4jRepository to provide CRUD operations for ListInfo entities.
    // You can add custom query methods here if needed.
    @Query("Match (m:plant) return ID(m) as id,m.taxon_name as taxon_name,m.ch_name as ch_name,m.taxon_rank as taxon_rank SKIP $start LIMIT $size")
    List<ListInfo> findListInfoWithPage(int start, int size);

    @Query("MATCH (m:plant) Where m.ch_name contains $ch_name return ID(m) as id,m.taxon_name as taxon_name,m.ch_name as ch_name,m.taxon_rank as taxon_rank SKIP $start LIMIT $size")
    List<ListInfo> findListInfoByCh_NameContainingWithPage(String ch_name, int start, int size);

    @Query("MATCH (m:plant) Where m.taxon_name contains $taxon_name return ID(m) as id,m.taxon_name as taxon_name,m.ch_name as ch_name,m.taxon_rank as taxon_rank SKIP $start LIMIT $size")
    List<ListInfo> findListInfoByTaxonNameContainingWithPage(String taxon_name, int start, int size);

    @Query("match (m:plant) return count(m)")
    int countAllListInfo();

    @Query("match (m:plant) where m.taxon_name contains $taxon_name return count(m)")
    int countByTaxonName(String taxon_name);

    @Query("match (m:plant) where m.ch_name contains $ch_name return count(m)")
    int countByChName(String ch_name);


}
