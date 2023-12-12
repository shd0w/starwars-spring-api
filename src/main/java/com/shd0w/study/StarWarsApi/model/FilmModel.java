package com.shd0w.study.StarWarsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.net.URI;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmModel extends PagingModel implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FilmModel> results;

    private String title;

    private String episode_id;

    private String opening_crawl;

    private String director;

    private String producer;

    private Date release_date;

    private List<String> species;

    private List<String> starships;

    private List<String> vehicles;

    private List<String> characters;

    private List<String> planets;

    private Instant created;

    private Instant edited;

    private URI url;
}
