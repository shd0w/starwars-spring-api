package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.PlanetModel;
import com.shd0w.study.StarWarsApi.service.Planet.impl.PlanetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
@RequestMapping("/api/planets")
@Tag(name = "Planets", description = "SWAPI Planets Endpoint")
public class PlanetsController {
    @Autowired
    PlanetService planetService;

    @GetMapping
    public ResponseEntity<PlanetModel> getAllPeople(@Nullable Integer page, @Nullable String searchQuery) {
        return ResponseEntity.ok(planetService.getAllPlanets(page, searchQuery));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetModel> getPeopleById(@Nullable Integer id) {
        return ResponseEntity.ok(planetService.getPlanetById(id));
    }
}
