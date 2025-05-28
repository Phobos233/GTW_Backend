package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("species")
@Data
public class Species {

    @Id
    private long node_id;
    private int plant_id;
    private String taxon_rank;
    private String family;
    private String genus;
    private String genus_c;
    private String taxon_name;
    private String ch_name;
    private String area;
    private int publish_date;

}
