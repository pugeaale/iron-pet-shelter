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
     * Get all animals by a shelter id
     * @param shelterId the id of the animals shelter
     * @return the list of animals
     */
    List<Animal> getAnimalsByShelterId(Integer shelterId);
    /**
     * This method is used to retrieve an Animal by id from the database.
     * @param id the id of the Animal to be retrieved
     * @return the retrieved Animal
     */
    Animal getAnimalById(Integer id);

    /**
     * This method is used to save an animal entity to the database.
     * @param animal the animal to be saved
     * @return the saved animal
     */
    Animal saveAnimal(Animal animal);
}
