package com.shd0w.study.StarWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.net.URI;
import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleModel extends PagingModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PeopleModel[] results;

    private String name;

    private String height;

    private String mass;

    private String hair_color;

    private String skin_color;

    private String eye_color;

    private String birth_year;

    private String gender;

    private String homeworld;

    private List<String> films;

    private List<String> species;

    private List<String> vehicles;

    private List<String> tarships;

    private Instant created;

    private Instant edited;

    private URI url;


}
