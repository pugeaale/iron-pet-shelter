package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.model.Veterinarian;
import com.ironhack.petshelter.service.VeterinarianService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VeterinarianController {

    private final VeterinarianService veterinarianService;

    /**
     * Get a list of all veterinarians
     *
     * @return list of all veterinarians
     */
    @GetMapping("/veterinarians")
    @ResponseStatus(HttpStatus.OK)
    public List<Veterinarian> getVeterinarians() {
        return veterinarianService.getVeterinarians();
    }

    /**
     * Get a Veterinarian by id
     * @param id the id of the Veterinarian to be retrieved
     * @return the retrieved Veterinarian
     */
    @GetMapping("/veterinarians/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Veterinarian getVeterinarianById(@PathVariable Integer id) {
        return veterinarianService.getVeterinarianById(id);
    }

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
