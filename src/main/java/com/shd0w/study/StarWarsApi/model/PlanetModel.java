package com.shd0w.study.StarWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.net.URI;
import java.time.Instant;
import java.util.List;

@Data
@JsonIgnoreProperties
public class PlanetModel extends PagingModel implements Serializable {
    private List<PlanetModel> results;
    private String name;
    private String diameter;
    private String rotation_period;
    private String orbital_period;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    private String surface_water;
    private List<String> residents;
    private List<String> films;
    private URI url;
    private Instant created;
    private Instant edited;
}
