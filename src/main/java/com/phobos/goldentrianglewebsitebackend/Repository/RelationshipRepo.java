package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.Relationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationshipRepo extends Neo4jRepository<Relationship, Long> {
    @Query("MATCH ()-[r]->() RETURN ID(r) as id,type(r) as type,ID(startNode(r)) as startNodeId,ID(endNode(r)) as endNodeId")
    List<Relationship> findAllRelationships();

    @Query("Match (m)-[r]->(n) Where ID(r)=$RelationshipID return ID(r) as id,type(r) as type, ID(m) as startNodeId, ID(n) as endNodeId")
    List<Relationship> findNodeRelationshipByRelationshipID(long RelationshipID);
    @Query("Match (m)-[r]->(n) where ID(m)=$0 return ID(r) as id,type(r) as type, ID(m) as startNodeId, ID(n) as endNodeId")
    List<Relationship> findNodeRelationshipByStartNodeID(long startNodeID);
    @Query("Match (m)-[r]->(n) where ID(n)=$0 return ID(r) as id,type(r) as type, ID(m) as startNodeId, ID(n) as endNodeId")
    List<Relationship> findNodeRelationshipByEndNodeID(long endNodeID);

    @Query("match (m),(n) where Id(m)=$1 and Id(n)=$2 Create (m)-[r:$0]->(n)")
    void createNodeRelationship(String type, long startNodeId, long endNodeId);
    @Query("Match (m)-[r]->(n) Where ID(r)=$0 Delete r")
    void deleteNodeRelationship(long id);


}
