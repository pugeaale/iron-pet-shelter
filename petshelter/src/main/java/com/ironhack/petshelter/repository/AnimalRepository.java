package com.ironhack.petshelter.repository;

import com.ironhack.petshelter.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    /**
     * Get all animals by a shelter id
     * @param id the id of the animals shelter
     * @return the list of animals
     */
    List<Animal> findByShelter_Id(Integer id);
}
