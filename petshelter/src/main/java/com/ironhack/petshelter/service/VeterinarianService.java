package com.ironhack.petshelter.service;

import com.ironhack.petshelter.dto.VeterinarianDTO;
import com.ironhack.petshelter.model.Veterinarian;

import java.util.List;

public interface VeterinarianService {

    /**
     * This method is used to update a veterinarian entity to the database.
     * @param veterinarianDTO the veterinarian datas to update
     * @return the updated veterinarian
     */
    Veterinarian update(Long id, VeterinarianDTO veterinarianDTO);

    /**
     * This method is used to save a veterinarian entity to the database.
     * @param veterinarian the veterinarian to be saved
     * @return the saved veterinarian
     */
    Veterinarian save(Veterinarian veterinarian);


    /**
     * This method is used to retrieve all Veterinarian entities from the database.
     *
     * @return a List of all Veterinarian entities.
     */
    List<Veterinarian> getVeterinarians();

    /**
     * This method is used to retrieve all Veterinarian entities by city
     * @param city the city to search veterinarians
     * @return a List of Veterinarian entities filtered by city.
     */
    List<Veterinarian> getVeterinariansByCity(String city);

    /**
     * This method is used to retrieve a Veterinarian by id from the database.
     * @param id the id of the Veterinarian to be retrieved
     * @return the retrieved Veterinarian
     */
    Veterinarian getVeterinarianById(Long id);
}
