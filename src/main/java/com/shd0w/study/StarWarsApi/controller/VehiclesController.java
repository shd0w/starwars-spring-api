package com.shd0w.study.StarWarsApi.controller;

import com.shd0w.study.StarWarsApi.model.VehicleModel;
import com.shd0w.study.StarWarsApi.service.Vehicle.impl.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicles", description = "SWAPI Vehicles Endpoint")
public class VehiclesController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<VehicleModel> getAllVehicles(@RequestParam(required = false) Integer page, String searchQuery) {

        return ResponseEntity.ok(vehicleService.getAllVehicle(page, searchQuery));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> getVehiclesById(@PathVariable Integer id) {

        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

}
