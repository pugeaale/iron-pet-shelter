package com.ironhack.petshelter.repository;

import com.ironhack.petshelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
    /**
     * Get list of shelter by city
     * @param city the city to search
     * @return the list of shelter
     */
    List<Shelter> getShelterByCity(String city);
}
