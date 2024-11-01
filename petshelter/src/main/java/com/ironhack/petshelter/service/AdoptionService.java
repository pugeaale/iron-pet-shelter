package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Adoption;

import java.util.List;

public interface AdoptionService {

    /**
     * This method is used to retrieve all adoptions entities from the database.
     *
     * @return a List of all adoptions entities.
     */
    List<Adoption> getAdoptions();
}
