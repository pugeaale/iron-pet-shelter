package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.MedicalProcedure;
import com.ironhack.petshelter.service.MedicalProcedureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MedicalProcedureController {

    private final MedicalProcedureService medicalProcedureService;

    /**
     * Get a list of all medical procedures
     *
     * @return list of all medical procedures
     */
    @GetMapping("/medical-procedures")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalProcedure> getMedicalProcedures() {
        return medicalProcedureService.getMedicalProcedures();
    }

    /**
     * Save a new medical procedure
     *
     * @param animalId the animal id
     * @param veterinarianId the veterinarian id
     */
    @PostMapping("/medical-procedures")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMedicalProcedure(@RequestBody Integer animalId, Integer veterinarianId) {
        medicalProcedureService.create(animalId, veterinarianId);
    }

}