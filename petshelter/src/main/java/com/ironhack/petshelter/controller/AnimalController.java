package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.exception.ResourceNotFoundException;
import com.ironhack.petshelter.model.Animal;
import com.ironhack.petshelter.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnimalController {


    private final AnimalService animalService;

    /**
     * Get an Animal by id
     * @param id the id of the Animal to be retrieved
     * @return the retrieved Animal
     */
    @GetMapping("/animals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getAdopterById(@PathVariable Integer id) throws ResourceNotFoundException {
        Animal animal = animalService.getAnimalById(id);
        if (animal == null) {
            throw new ResourceNotFoundException("animal not found with id: " + id);
        }
        return animalService.getAnimalById(id);
    }

    /**
     * Get animals by shelter
     * @param shelterId the id of the shelter
     * @return the filtered list of animals
     */
    @GetMapping("/animals-by-shelter")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAnimalsByShelter(@RequestParam Integer shelterId) {
        return animalService.getAnimalsByShelterId(shelterId);
    }

    /**
     * Get a list of all animals
     *
     * @return list of all animals
     */
    @GetMapping("/animals")
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }
}
