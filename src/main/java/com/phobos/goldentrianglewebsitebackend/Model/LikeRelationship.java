package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class LikeRelationship {
    @Id
    private long likeId;
    private String author;
    private String authorId;
    private String likeTo;
    private String likeToId;
    private String datetime;
}
