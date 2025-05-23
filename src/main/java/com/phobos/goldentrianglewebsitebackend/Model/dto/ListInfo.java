package com.phobos.goldentrianglewebsitebackend.Model.dto;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;

@Data
public class ListInfo {
    @Id
    private long id;
    private String taxon_rank;
    private String taxon_name;
    private String ch_name;
}
