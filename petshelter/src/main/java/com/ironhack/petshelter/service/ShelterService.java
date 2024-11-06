package com.ironhack.petshelter.service;

import com.ironhack.petshelter.dto.ShelterDTO;
import com.ironhack.petshelter.model.Shelter;

import java.util.List;

public interface ShelterService {

    /**
     * This method is used to update a Shelter entity to the database.
     * @param shelterDTO the Shelter datas to update
     * @return the updated Shelter
     */
    Shelter update(Long id, ShelterDTO shelterDTO);

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
     * This method is used to retrieve all shelter entities by city
     * @param city the city to search shelters
     * @return a List of shelter entities filtered by city.
     */
    List<Shelter> getSheltersByCity(String city);

    /**
     * This method is used to retrieve a shelter by id from the database.
     * @param id the id of the shelter to be retrieved
     * @return the retrieved shelter
     */
    Shelter getShelterById(Long id);

    /**
     * This method is used to add an animal by id to a shelter by id
     * @param animalId the id of the animal to add to the shelter
     * @param shelterId the id of the shelter to add the animal
     */
    void addAnimalToShelter(Integer animalId, Long shelterId);

    /**
     * This method is used to add an employee by id to a shelter by id
     * @param employeeId the id of the employee to add to the shelter
     * @param shelterId the id of the shelter to add the employee
     */
    void addEmployeeToShelter(Long employeeId, Long shelterId);
}
