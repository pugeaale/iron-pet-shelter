package com.ironhack.petshelter.service;

import com.ironhack.petshelter.dto.AdopterDTO;
import com.ironhack.petshelter.dto.VeterinarianDTO;
import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.model.Veterinarian;

import java.util.List;

public interface AdopterService {


    /**
     * This method is used to update a Adopter entity to the database.
     * @param adopterDTO the Adopter datas to update
     * @return the updated Adopter
     */
    Adopter update(Long id, AdopterDTO adopterDTO);

    /**
     * This method is used to save a adopter entity to the database.
     * @param adopter the adopter to be saved
     * @return the saved adopter
     */
    Adopter save(Adopter adopter);
    /**
     * This method is used to retrieve a adopter by id from the database.
     * @param id the id of the adopter to be retrieved
     * @return the retrieved adopter
     */
    Adopter getAdopterById(Long id);
    /**
     * This method is used to retrieve all Adopter entities from the database.
     *
     * @return a List of all Adopter entities.
     */
    List<Adopter> getAdopters();
}
