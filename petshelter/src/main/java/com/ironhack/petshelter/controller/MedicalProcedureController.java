package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.MedicalProcedureDTO;
import com.ironhack.petshelter.model.MedicalProcedure;
import com.ironhack.petshelter.service.MedicalProcedureService;
import jakarta.validation.Valid;
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
     * Get medical procedures by animal
     * @param animalId the id of the animal
     * @return the filtered list of medical procedures
     */
    @GetMapping("/medical-procedures-by-animal")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalProcedure> getMedicalProceduresByAnimal(@RequestParam Integer animalId) {
        return medicalProcedureService.getMedicalProceduresByAnimal(animalId);
    }

    /**
     * Get medical procedures by veterinarian
     * @param veterinarianId the id of the veterinarian
     * @return the filtered list of medical procedures
     */
    @GetMapping("/medical-procedures-by-veterinarian")
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalProcedure> getMedicalProceduresByVeterinarian(@RequestParam Long veterinarianId) {
        return medicalProcedureService.getMedicalProceduresByVeterinarian(veterinarianId);
    }

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
     */
    @PostMapping("/medical-procedures")
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalProcedure createMedicalProcedure(@RequestBody @Valid MedicalProcedureDTO medicalProcedureDTO) {
        return medicalProcedureService.create(medicalProcedureDTO);
    }

    /**
     * delete a medical procedure
     *
     * @param id the id of the medical procedure
     */
    @DeleteMapping("/medical-procedures/{id}")
    public void deleteMedicalProcedure(@PathVariable Integer id) {
        medicalProcedureService.deleteMedicalProcedure(id);
    }

}
