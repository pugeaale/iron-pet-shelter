package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.model.Shelter;
import com.ironhack.petshelter.service.AdopterService;
import com.ironhack.petshelter.service.ShelterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdopterController {

    private final AdopterService adopterService;

    /**
     * Save a new adopter
     *
     * @param adopter the adopter to be saved
     */
    @PostMapping("/adopters")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAdopter(@RequestBody Adopter adopter) {
        adopterService.save(adopter);
    }
}
