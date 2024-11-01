package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Animal;
import com.ironhack.petshelter.repository.AnimalRepository;
import com.ironhack.petshelter.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Animal saveAnimal(Animal animal) {
        log.info("Saving animal {}", animal.getId());
        return animalRepository.save(animal);
    }

    @Override
    public Animal getAnimalById(Integer id) {
        log.info("Fetching Animal by id {}", id);
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElse(null);
    }


}
