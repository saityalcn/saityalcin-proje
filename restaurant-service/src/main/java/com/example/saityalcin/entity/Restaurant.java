package com.example.saityalcin.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "restaurants")
@Getter
@Setter
public class Restaurant {

    @Id
    @Indexed
    private Long id;

    @Indexed
    private String name;

    @Indexed
    private Double latitude;

    @Indexed
    private Double longitude;

}
