package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.model.Veterinarian;

import java.util.List;

public interface VeterinarianService {

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
}
