package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Dog;
import com.ironhack.petshelter.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    /**
     * Get a list of all dogs
     *
     * @return list of all dogs
     */
    @GetMapping("/dogs")
    @ResponseStatus(HttpStatus.OK)
    public List<Dog> getDogs() {
        return dogService.getDogs();
    }

    /**
     * Save a new dog
     *
     * @param dog the dog to be saved
     */
    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDog(@RequestBody Dog dog) {
        dogService.save(dog);
    }
}
