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

    /**
     * This method is used to save a Adoption entity to the database.
     * @param animalId the animal id to be adopted
     * @param adopterId the adopter id who is adopting
     * @return the saved Adoption
     */
    Adoption create(Integer animalId, Integer adopterId);

}
