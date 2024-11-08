package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.VeterinarianDTO;
import com.ironhack.petshelter.exception.ResourceNotFoundException;
import com.ironhack.petshelter.model.Veterinarian;
import com.ironhack.petshelter.service.VeterinarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/veterinarians-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Veterinarian> getVeterinarianById(@PathVariable Long id) throws ResourceNotFoundException {
        Veterinarian user = veterinarianService.getVeterinarianById(id);
        if(user == null) {
            throw new ResourceNotFoundException("vet not found on :: " + id);
        }
        return ResponseEntity.ok().body(user);
    }

    /**
     * Get Veterinarians by city
     * @param city the city of Veterinarians to be retrieved
     * @return the filtered list of Veterinarian
     */
    @GetMapping("/veterinarians/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<Veterinarian> getVeterinarianByCity(@PathVariable String city) {
        return veterinarianService.getVeterinariansByCity(city);
    }

    @PatchMapping("/veterinarians/{id}")
    public Veterinarian update(@PathVariable Long id, @RequestBody VeterinarianDTO updatedVeterinarianDTO) {
        return veterinarianService.update(id, updatedVeterinarianDTO);
    }

    /**
     * Save a new veterinarian
     *
     * @param veterinarian the veterinarian to be saved
     */
    @PostMapping("/veterinarians")
    @ResponseStatus(HttpStatus.CREATED)
    public Veterinarian saveVeterinarian(@RequestBody @Valid Veterinarian veterinarian) {
        return veterinarianService.save(veterinarian);
    }
}
