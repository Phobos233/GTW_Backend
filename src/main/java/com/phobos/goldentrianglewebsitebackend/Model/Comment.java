package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class Comment {
    @Id
    private long commentId;
    private String content;
    private String author;
    private String authorId;
    private String datetime;
    private String commentTo;
    private String commentToId;
}
