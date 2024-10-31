package com.ironhack.petshelter.controller;

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
    public Animal getAdopterById(@PathVariable Integer id) {
        return animalService.getAnimalById(id);
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
