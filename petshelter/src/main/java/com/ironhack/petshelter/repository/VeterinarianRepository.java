package com.ironhack.petshelter.repository;

import com.ironhack.petshelter.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {

    /**
     * Get list of veterinarian by city
     * @param city the city to search
     * @return the list of veterinarian
     */
    List<Veterinarian> getVeterinarianByCity(String city);
}
