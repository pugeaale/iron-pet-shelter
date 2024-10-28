package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Shelter;

public interface ShelterService {

    /**
     * This method is used to save a Shelter entity to the database.
     * @param shelter the shelter to be saved
     * @return the saved shelter
     */
    Shelter save(Shelter shelter);
}
