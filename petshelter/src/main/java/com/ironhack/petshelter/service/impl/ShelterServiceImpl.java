package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Animal;
import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.model.Shelter;
import com.ironhack.petshelter.repository.ShelterRepository;
import com.ironhack.petshelter.service.AnimalService;
import com.ironhack.petshelter.service.EmployeeService;
import com.ironhack.petshelter.service.ShelterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {

    private final ShelterRepository shelterRepository;
    private final AnimalService animalService;
    private final EmployeeService employeeService;

    @Transactional
    @Override
    public Shelter save(Shelter shelter) {
        log.info("Saving new shelter {} to the database", shelter.getName());
        return shelterRepository.save(shelter);
    }

    @Override
    public List<Shelter> getShelters() {
        log.info("Fetching all shelters");
        return shelterRepository.findAll();
    }

    @Override
    public Shelter getShelterById(Integer id) {
        log.info("Fetching shelter by id {}", id);
        Optional<Shelter> shelter = shelterRepository.findById(id);
        return shelter.orElse(null);
    }

    @Override
    @Transactional
    public void addAnimalToShelter(Integer animalId, Integer shelterId) {
        Animal animal = animalService.getAnimalById(animalId);
        if( animal == null )
            throw new IllegalArgumentException("Animal not found");
        Shelter shelter = getShelterById(shelterId);
        if( shelter == null )
            throw new IllegalArgumentException("Shelter not found");
        animal.setShelter(shelter);
        animalService.saveAnimal(animal);
        shelter.getAnimals().add(animal);
        save(shelter);
    }

    @Override
    @Transactional
    public void addEmployeeToShelter(Integer employeeId, Integer shelterId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if( employee == null )
            throw new IllegalArgumentException("Employee not found");
        Shelter shelter = getShelterById(shelterId);
        if( shelter == null )
            throw new IllegalArgumentException("Shelter not found");
        employee.setShelter(shelter);
        employeeService.save(employee);
        shelter.getEmployees().add(employee);
        save(shelter);
    }
}
