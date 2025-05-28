package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class LikeRelationship {
    @Id
    private long likeId;
    private String author;
    private long authorId;
    private String likeTo;
    private long likeToId;
    private String datetime;
}
