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

}
