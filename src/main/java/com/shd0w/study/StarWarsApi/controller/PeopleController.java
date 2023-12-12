package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.PeopleModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

import static com.shd0w.study.StarWarsApi.utils.GetUri.getUri;

@ResponseBody
@RequestMapping("/api/people")
@RestController
public class PeopleController {


    private static final URI endpointUri = URI.create("https://swapi.dev/api/people");
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public ResponseEntity<PeopleModel> getAllPeople(@RequestParam(required = false) Integer page, String searchQuery) {

        URI uri = getUri(page, searchQuery, endpointUri);
        System.out.println("uri = " + uri);

        try {
            ResponseEntity<PeopleModel> response = restTemplate.exchange(uri, HttpMethod.GET, null, PeopleModel.class);
            return response;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleModel> getPeopleById(@PathVariable Integer id) {

        URI uri = getUri(null, null, endpointUri);

        PeopleModel listPeople = restTemplate.getForObject(uri + "/" + id, PeopleModel.class);

        return ResponseEntity.ok(listPeople);
    }


}
