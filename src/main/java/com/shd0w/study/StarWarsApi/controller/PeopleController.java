package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.PeopleModel;
import com.shd0w.study.StarWarsApi.service.People.impl.PeopleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RequestMapping("/api/peoples")
@RestController
@Tag(name="People", description = "SWAPI People Endpoint")
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @GetMapping
    public ResponseEntity<PeopleModel> getAllPeople(@RequestParam(required = false) Integer page, @RequestParam(required = false) String searchQuery) {
        return ResponseEntity.ok(peopleService.getAllPeople(page, searchQuery));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleModel> getPeopleById(@PathVariable Integer id) {
        return ResponseEntity.ok(peopleService.getPeopleById(id));
    }


}
