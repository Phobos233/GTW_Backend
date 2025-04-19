package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.Relationship;

import java.util.List;

public interface RelationshipService {
    List<Relationship> findAllRelationships();
    List<Relationship> findRelationshipByRelationshipID(long RelationshipID);
    List<Relationship> findRelationshipByStartNodeID(long startNodeID);
    List<Relationship> findRelationshipByEndNodeID(long endNodeID);
    void createNodeRelationship(String type, long startNodeId, long endNodeId);
    void deleteNodeRelationship(long id);
}
