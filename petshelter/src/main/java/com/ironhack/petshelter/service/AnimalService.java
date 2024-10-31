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
    /**
     * This method is used to retrieve an Animal by id from the database.
     * @param id the id of the Animal to be retrieved
     * @return the retrieved Animal
     */
    Animal getAnimalById(Integer id);
}
