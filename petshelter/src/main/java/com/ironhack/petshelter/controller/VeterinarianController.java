package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Veterinarian;
import com.ironhack.petshelter.service.VeterinarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VeterinarianController {

    private final VeterinarianService veterinarianService;

    /**
     * Save a new veterinarian
     *
     * @param veterinarian the veterinarian to be saved
     */
    @PostMapping("/veterinarians")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVeterinarian(@RequestBody Veterinarian veterinarian) {
        veterinarianService.save(veterinarian);
    }
}
