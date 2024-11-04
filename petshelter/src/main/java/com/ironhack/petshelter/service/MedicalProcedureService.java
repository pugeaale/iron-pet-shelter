package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.MedicalProcedure;

import java.util.List;

public interface MedicalProcedureService {


    /**
     * This method is used to retrieve all medical procedures entities for an animal
     *
     * @return a List of all medical procedures entities for an anima.
     */
    List<MedicalProcedure> getMedicalProceduresByAnimal(Integer animalId);

    /**
     * This method is used to retrieve all medical procedures entities from the database.
     *
     * @return a List of all medical procedures entities.
     */
    List<MedicalProcedure> getMedicalProcedures();

    /**
     * This method is used to save a medical procedure entity to the database.
     * @param animalId the animal id
     * @param veterinarianId the veterinarian id
     * @return the saved medical procedure
     */
    MedicalProcedure create(Integer animalId, Integer veterinarianId);

}
