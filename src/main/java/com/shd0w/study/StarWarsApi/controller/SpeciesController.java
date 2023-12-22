package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.SpecieModel;
import com.shd0w.study.StarWarsApi.service.Species.impl.SpeciesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/api/species")
@Tag(name = "Species", description = "SWAPI Species Endpoint")
public class SpeciesController {

    @Autowired
    SpeciesService speciesService;

    @GetMapping
    public ResponseEntity<SpecieModel> getAllSpecies(@RequestParam(required = false) Integer page, String searchQuery) {
        return ResponseEntity.ok(speciesService.getAllSpecies(page, searchQuery));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecieModel> getSpeciesById(@PathVariable Integer id) {

        return ResponseEntity.ok(speciesService.getSpeciesById(id));
    }
}
