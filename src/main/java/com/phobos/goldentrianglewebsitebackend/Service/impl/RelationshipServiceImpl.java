package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.Relationship;
import com.phobos.goldentrianglewebsitebackend.Repository.RelationshipRepo;
import com.phobos.goldentrianglewebsitebackend.Service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    private final RelationshipRepo relationshipRepo;
    @Autowired
    public RelationshipServiceImpl(RelationshipRepo relationshipRepo) {
        this.relationshipRepo = relationshipRepo;
    }

    @Override
    public List<Relationship> findAllRelationships() {
        return relationshipRepo.findAllRelationships();
    }

    @Override
    public List<Relationship> findRelationshipByRelationshipID(long RelationshipID) {
        return relationshipRepo.findNodeRelationshipByRelationshipID(RelationshipID);
    }

    @Override
    public List<Relationship> findRelationshipByStartNodeID(long startNodeID) {
        return relationshipRepo.findNodeRelationshipByStartNodeID(startNodeID);
    }

    @Override
    public List<Relationship> findRelationshipByEndNodeID(long endNodeID) {
        return relationshipRepo.findNodeRelationshipByEndNodeID(endNodeID);
    }

    @Override
    public void createNodeRelationship(String type, long startNodeId, long endNodeId) {
        relationshipRepo.createNodeRelationship(type, startNodeId, endNodeId);
    }

    @Override
    public void deleteNodeRelationship(long id) {
        relationshipRepo.deleteNodeRelationship(id);
    }
}
