package com.ironhack.petshelter.service;

import com.ironhack.petshelter.dto.AdoptionDTO;
import com.ironhack.petshelter.model.Adoption;

import java.time.LocalDate;
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
     *
     * @return the saved Adoption
     */
    Adoption create(AdoptionDTO adoptionDTO);

}
