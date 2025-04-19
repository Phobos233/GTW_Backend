package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.dto.ChartsEdgeInfo;
import com.phobos.goldentrianglewebsitebackend.Model.Relationship;
import com.phobos.goldentrianglewebsitebackend.Service.RelationshipService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RelationshipController {
    private final RelationshipService relationshipService;
    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @RequestMapping("/findAllRelationships")
    public List<Relationship> findAllRelationships(){
        System.out.println(relationshipService.findAllRelationships().toString());
        return relationshipService.findAllRelationships();
    }

    @RequestMapping("/getRelationshipByStartNodeId")
    public List<Relationship> getRelationshipByStartNodeId(long startNodeId) {
        return relationshipService.findRelationshipByStartNodeID(startNodeId);
    }

    @RequestMapping("/createRelationship")
    public void createRelationship(long startNodeId, long endNodeId ,String relationshipType) {
        relationshipService.createNodeRelationship(relationshipType,startNodeId, endNodeId );
    }
    @RequestMapping("/deleteRelationship")
    public void deleteRelationship(long id) {
        relationshipService.deleteNodeRelationship(id);
    }
    @RequestMapping("/getEdgesForCharts")
    public List<ChartsEdgeInfo> getAllEdgesForCharts() {
        List<Relationship> relationships = relationshipService.findAllRelationships();
        List<ChartsEdgeInfo> chartsEdgeInfos = new ArrayList<>();
        for (Relationship relationship : relationships) {
            ChartsEdgeInfo chartsEdgeInfo = new ChartsEdgeInfo();
            chartsEdgeInfo.setSource(relationship.getStartNodeId());
            chartsEdgeInfo.setValue(relationship.getType());
            chartsEdgeInfo.setTarget(relationship.getEndNodeId());
            chartsEdgeInfos.add(chartsEdgeInfo);
        }
        return chartsEdgeInfos;
    }
}
