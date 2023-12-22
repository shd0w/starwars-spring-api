package com.shd0w.study.StarWarsApi.service.Vehicle.interfaces;

import com.shd0w.study.StarWarsApi.model.VehicleModel;
import jakarta.annotation.Nullable;

public interface VehicleInterface {
    VehicleModel getAllVehicle(@Nullable Integer page, @Nullable String searchQuery);

    VehicleModel getVehicleById(@Nullable Integer id);
}
