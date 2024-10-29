package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Dog;

import java.util.List;

public interface DogService {

    /**
     * This method is used to save a Dog entity to the database.
     * @param dog the dog to be saved
     * @return the saved dog
     */
    Dog save(Dog dog);
    /**
     * This method is used to retrieve all dog entities from the database.
     *
     * @return a List of all dog entities.
     */
    List<Dog> getDogs();
}
