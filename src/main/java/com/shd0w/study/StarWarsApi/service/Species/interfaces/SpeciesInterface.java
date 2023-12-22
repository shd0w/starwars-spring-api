package com.shd0w.study.StarWarsApi.service.Species.interfaces;

import com.shd0w.study.StarWarsApi.model.SpecieModel;
import jakarta.annotation.Nullable;

public interface SpeciesInterface {
    SpecieModel getAllSpecies(@Nullable Integer page, @Nullable String searchQuery);

    SpecieModel getSpeciesById(@Nullable Integer id);
}
