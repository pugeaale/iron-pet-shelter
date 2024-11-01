package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Shelter;

import java.util.List;

public interface ShelterService {

    /**
     * This method is used to save a Shelter entity to the database.
     * @param shelter the shelter to be saved
     * @return the saved shelter
     */
    Shelter save(Shelter shelter);
    /**
     * This method is used to retrieve all shelter entities from the database.
     *
     * @return a List of all shelter entities.
     */
    List<Shelter> getShelters();

    /**
     * This method is used to retrieve a shelter by id from the database.
     * @param id the id of the shelter to be retrieved
     * @return the retrieved shelter
     */
    Shelter getShelterById(Integer id);

    /**
     * This method is used to add an animal by id to a shelter by id
     * @param animalId the id of the animal to add to the shelter
     * @param shelterId the id of the shelter to add the animal
     */
    void addAnimalToShelter(Integer animalId, Integer shelterId);
}
