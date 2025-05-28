package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class CollectRelationship {
    @Id
    private long CollectId;
    private String Collector;
    private long CollectorId;
    private String Collection;
    private long CollectionId;
    private String datetime;
}
