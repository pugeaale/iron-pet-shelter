package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Veterinarian;

public interface VeterinarianService {

    /**
     * This method is used to save a veterinarian entity to the database.
     * @param veterinarian the veterinarian to be saved
     * @return the saved veterinarian
     */
    Veterinarian save(Veterinarian veterinarian);
}
