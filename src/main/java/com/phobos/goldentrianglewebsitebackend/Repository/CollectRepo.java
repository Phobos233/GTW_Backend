package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.CollectRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectRepo extends Neo4jRepository<CollectRelationship, Long> {

    @Query("return apoc.date.format(timestamp(),'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime")
    String getDatetime();

    @Query("MATCH (m:user)-[r:collect]->(n:plant) RETURN ID(r) as CollectId" +
            ", m.username as Collector" +
            ", ID(m) as CollectorId" +
            ", n.ch_name as Collection" +
            ", ID(n) as CollectionId" +
            ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime")
    List<CollectRelationship> getAllCollectRelationship();

    @Query("MATCH (m:user)-[r:collect]->(n:plant) WHERE ID(m) = $id RETURN ID(r) as CollectId" +
            ", m.username as Collector" +
            ", ID(m) as CollectorId" +
            ", n.ch_name as Collection" +
            ", ID(n) as CollectionId" +
            ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime")
    List<CollectRelationship> getCollectRelationshipByUserId(long id);

    @Query("Match (m:user)-[r:collect]->(n:plant) WHERE ID(m) = $collectorId AND ID(n) = $collectionId " +
            "RETURN ID(r) as CollectId" +
            ", m.username as Collector" +
            ", ID(m) as CollectorId" +
            ", n.ch_name as Collection" +
            ", ID(n) as CollectionId" +
            ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime")
    List<CollectRelationship> getCollectRelationshipByCollectorIdAndCollectorId(long collectorId, long collectionId);

    //分页
    @Query("MATCH (m:user)-[r:collect]->(n:plant) WHERE ID(m) = $id RETURN ID(r) as CollectId" +
            ", m.username as Collector" +
            ", ID(m) as CollectorId" +
            ", n.ch_name as Collection" +
            ", ID(n) as CollectionId" +
            ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime SKIP $skip LIMIT $limit")
    List<CollectRelationship> getCollectRelationshipByUserIdWithPage(long id, long skip, long limit);

    //增删
    @Query("MATCH (m:user)-[r:collect]->(n:plant) WHERE ID(r) = $id DELETE ID(r) as id")
    void deleteCollectRelationship(long id);

    @Query("MATCH (m:user),(n:plant) WHERE ID(m) = $userId AND ID(n) = $plantId CREATE (m)-[r:collect{timestamp:timestamp()}]->(n) " +
            "RETURN ID(r) as CollectId" +
            ", m.username as Collector" +
            ", ID(m) as CollectorId" +
            ", n.ch_name as Collection" +
            ", ID(n) as CollectionId" +
            ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime")
    List<CollectRelationship> createCollectRelationship(long userId, long plantId);

    @Query("MATCH (m:user)-[r:collect]->(n:plant) WHERE ID(m) = $collectorId return count(r)")
    int countCollectByCollectorId(long collectorId);


}
