package com.shd0w.study.StarWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.net.URI;
import java.time.Instant;
import java.util.List;

@Data
@JsonIgnoreProperties
public class SpecieModel extends PagingModel implements Serializable {
    private List<SpecieModel> results;
    private String name;
    private String classification;
    private String designation;
    private String average_height;
    private String average_lifespan;
    private String eye_colors;
    private String hair_colors;
    private String skin_colors;
    private String language;
    private String homeworld;
    private List<String> people;
    private List<String> films;
    private URI url;
    private Instant created;
    private Instant edited;
}
