package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Dog;
import com.ironhack.petshelter.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    /**
     * Save a new dog
     *
     * @param dog the dog to be saved
     */
    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveShelter(@RequestBody Dog dog) {
        dogService.save(dog);
    }
}
