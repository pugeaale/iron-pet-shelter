package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Dog;

public interface DogService {

    /**
     * This method is used to save a Dog entity to the database.
     * @param dog the dog to be saved
     * @return the saved dog
     */
    Dog save(Dog dog);
}
