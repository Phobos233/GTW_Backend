package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Data
@Node("Plant")
public class Plant {
    @Id
    private long id;
    private List<String>label;
    private String Taxon;
    private String Family;
    private String Region;
    private String Country;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public List<String> getLabel() {
//        return label;
//    }
//
//    public void setLabel(List<String> label) {
//        this.label = label;
//    }
//
//    public String getTaxon() {
//        return Taxon;
//    }
//
//    public void setTaxon(String taxon) {
//        this.Taxon = taxon;
//    }
//
//    public String getFamily() {
//        return Family;
//    }
//
//    public void setFamily(String family) {
//        this.Family = family;
//    }
//
//    public String getRegion() {
//        return Region;
//    }
//
//    public void setRegion(String region) {
//        this.Region = region;
//    }
//
//    public String getCountry() {
//        return Country;
//    }
//
//    public void setCountry(String country) {
//        this.Country = country;
//    }
//
//    @Override
//    public String toString() {
//        return "Plant{" +
//                "id=" + id +
//                ", label=" + label +
//                ", taxon='" + Taxon + '\'' +
//                ", family='" + Family + '\'' +
//                ", region='" + Region + '\'' +
//                ", country='" + Country + '\'' +
//                '}';
//    }
//
//    public Plant(long id, List<String> label, String taxon, String family, String region, String country) {
//        this.id = id;
//        this.label = label;
//        this.Taxon = taxon;
//        this.Family = family;
//        this.Region = region;
//        this.Country = country;
//    }
//
//    public Plant() {
//    }
}
