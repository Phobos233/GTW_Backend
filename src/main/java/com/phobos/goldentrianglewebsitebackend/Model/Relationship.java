package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class Relationship {
    @Id
    private long id;
    private String type;
    private long startNodeId;
    private long endNodeId;
}
