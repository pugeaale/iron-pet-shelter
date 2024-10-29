package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Cat;

import java.util.List;

public interface CatService {

    /**
     * This method is used to save a Cat entity to the database.
     * @param cat the cat to be saved
     * @return the saved cat
     */
    Cat save(Cat cat);

    /**
     * This method is used to retrieve all cat entities from the database.
     *
     * @return a List of all cat entities.
     */
    List<Cat> getCats();
}
