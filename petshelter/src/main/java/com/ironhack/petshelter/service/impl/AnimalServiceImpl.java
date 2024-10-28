package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Animal;
import com.ironhack.petshelter.repository.AnimalRepository;
import com.ironhack.petshelter.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    /**
     * Retrieves all animals from the database
     *
     * @return a list of all animals
     */
    @Override
    public List<Animal> getAnimals() {
        log.info("Fetching all animals");
        return animalRepository.findAll();
    }
}
