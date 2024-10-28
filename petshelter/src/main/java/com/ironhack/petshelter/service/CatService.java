package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Cat;

public interface CatService {

    /**
     * This method is used to save a Cat entity to the database.
     * @param cat the cat to be saved
     * @return the saved cat
     */
    Cat save(Cat cat);
}
