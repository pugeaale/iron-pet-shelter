package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.MedicalProcedure;

import java.util.List;

public interface MedicalProcedureService {


    /**
     * This method is used to retrieve all medical procedures entities from the database.
     *
     * @return a List of all medical procedures entities.
     */
    List<MedicalProcedure> getMedicalProcedures();

}
