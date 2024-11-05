package com.ironhack.petshelter.repository;

import com.ironhack.petshelter.model.MedicalProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalProcedureRepository extends JpaRepository<MedicalProcedure, Integer> {

    /**
     * Find all medical procedures by animal
     * @param animalId the id of animal
     * @return the list of medical procedures by animal id
     */
    List<MedicalProcedure> findMedicalProcedureByAnimal_Id(Integer animalId);

    /**
     * Find all medical procedures by veterinarian
     * @param veterinarianId the id of veterinarian
     * @return the list of medical procedures by veterinarian id
     */
    List<MedicalProcedure> findMedicalProcedureByVeterinarianId(Long veterinarianId);

}
