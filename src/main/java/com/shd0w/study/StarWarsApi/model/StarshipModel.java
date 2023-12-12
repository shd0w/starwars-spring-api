package com.shd0w.study.StarWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.net.URI;
import java.time.Instant;
import java.util.List;

@Data
@JsonIgnoreProperties
public class StarshipModel extends PagingModel implements Serializable {
    private List<StarshipModel> results;
    private String name;
    private String model;
    private String starship_class;
    private String manufactures;
    private String cost_in_credits;
    private String length;
    private String crew;
    private String passengers;
    private String max_atmospheric_speed;
    private String hyperdrive_rating;
    private String MGLT;
    private String cargo_capacity;
    private String consumables;
    private List<String> films;
    private List<String> pilots;
    private URI url;
    private Instant created;
    private Instant edited;
}
