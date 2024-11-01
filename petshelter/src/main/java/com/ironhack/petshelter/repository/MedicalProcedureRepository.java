package com.ironhack.petshelter.repository;

import com.ironhack.petshelter.model.MedicalProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalProcedureRepository extends JpaRepository<MedicalProcedure, Integer> {
}
