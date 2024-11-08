package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.AnimalToShelterDTO;
import com.ironhack.petshelter.dto.EmployeeToShelterDTO;
import com.ironhack.petshelter.dto.ShelterDTO;
import com.ironhack.petshelter.exception.ResourceNotFoundException;
import com.ironhack.petshelter.model.Shelter;
import com.ironhack.petshelter.service.ShelterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterService shelterService;

    @PatchMapping("/shelters/{id}")
    public Shelter update(@PathVariable Long id, @RequestBody ShelterDTO shelterDTO) {
        return shelterService.update(id, shelterDTO);
    }

    /**
     * Get a list of all shelters
     *
     * @return list of all shelters
     */
    @GetMapping("/shelters")
    @ResponseStatus(HttpStatus.OK)
    public List<Shelter> getShelters() {
        return shelterService.getShelters();
    }

    /**
     * Get shelters by city
     * @param city the city of shelters to be retrieved
     * @return the filtered list of shelters
     */
    @GetMapping("/shelters-by-city")
    @ResponseStatus(HttpStatus.OK)
    public List<Shelter> getSheltersByCity(@RequestParam String city) {
        return shelterService.getSheltersByCity(city);
    }

    /**
     * Get a shelter by id
     * @param id the id of the shelter to be retrieved
     * @return the retrieved shelter
     */
    @GetMapping("/shelters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Shelter> getShelterById(@PathVariable Long id) throws ResourceNotFoundException {
        Shelter shelter = shelterService.getShelterById(id);
        if(shelter == null) {
            throw new ResourceNotFoundException("shelter not found with id: " + id);
        }
        return ResponseEntity.ok().body(shelter);
    }

    /**
     * Save a new shelter
     *
     * @param shelter the shelter to be saved
     */
    @PostMapping("/shelters")
    @ResponseStatus(HttpStatus.CREATED)
    public Shelter saveShelter(@RequestBody @Valid Shelter shelter) {
        return shelterService.save(shelter);
    }

    /**
     * Add an animal to shelter
     *
     * @param animalToShelterDTO DTO containing the animal id and shelter id
     */
    @PatchMapping("/shelters/add-animal")
    @ResponseStatus(HttpStatus.OK)
    public void addAnimalToShelter(@RequestBody AnimalToShelterDTO animalToShelterDTO) {
        shelterService.addAnimalToShelter(animalToShelterDTO.getAnimalId(), animalToShelterDTO.getShelterId());
    }

    /**
     * Add an employee to shelter
     *
     * @param employeeToShelterDTO DTO containing the employee id and shelter id
     */
    @PatchMapping("/shelters/add-employee")
    @ResponseStatus(HttpStatus.OK)
    public void addEmployeeToShelter(@RequestBody EmployeeToShelterDTO employeeToShelterDTO) {
        shelterService.addEmployeeToShelter(employeeToShelterDTO.getEmployeeId(), employeeToShelterDTO.getShelterId());
    }
}
