package com.shd0w.study.StarWarsApi.service.People.interfaces;

import com.shd0w.study.StarWarsApi.model.PeopleModel;
import jakarta.annotation.Nullable;

public interface PeopleInterface {


    PeopleModel getAllPeople(@Nullable Integer page, @Nullable String searchQuery);

    PeopleModel getPeopleById(@Nullable Integer id);
}
