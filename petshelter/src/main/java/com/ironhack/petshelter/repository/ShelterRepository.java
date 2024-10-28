package com.ironhack.petshelter.repository;

import com.ironhack.petshelter.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {
}
