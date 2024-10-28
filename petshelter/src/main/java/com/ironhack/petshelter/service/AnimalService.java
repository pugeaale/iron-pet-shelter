package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Animal;

import java.util.List;

public interface AnimalService {

    /**
     * This method is used to retrieve all Animal entities from the database.
     *
     * @return a List of all Animal entities.
     */
    List<Animal> getAnimals();
}
