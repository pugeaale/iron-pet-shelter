package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Adoption;
import com.ironhack.petshelter.service.AdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AdoptionController {

    private final AdoptionService adoptionService;

    /**
     * Get a list of all adoptions
     *
     * @return list of all adoptions
     */
    @GetMapping("/adoptions")
    @ResponseStatus(HttpStatus.OK)
    public List<Adoption> getAdoptions() {
        return adoptionService.getAdoptions();
    }

}
