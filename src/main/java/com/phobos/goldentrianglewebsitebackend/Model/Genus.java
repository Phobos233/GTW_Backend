package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("genus")
public class Genus {
    @Id
    private long node_id;
    private int plant_id;
    private String taxon_rank;
    private String family;
    private String taxon_name;
    private String ch_name;
}
