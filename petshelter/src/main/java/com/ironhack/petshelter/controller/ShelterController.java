package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.AnimalToShelterDTO;
import com.ironhack.petshelter.dto.EmployeeToShelterDTO;
import com.ironhack.petshelter.model.Shelter;
import com.ironhack.petshelter.model.Veterinarian;
import com.ironhack.petshelter.service.ShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShelterController {

    private final ShelterService shelterService;

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
    public Shelter getShelterById(@PathVariable Integer id) {
        return shelterService.getShelterById(id);
    }

    /**
     * Save a new shelter
     *
     * @param shelter the shelter to be saved
     */
    @PostMapping("/shelters")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveShelter(@RequestBody Shelter shelter) {
        shelterService.save(shelter);
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
