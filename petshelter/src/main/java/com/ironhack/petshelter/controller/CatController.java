package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Cat;
import com.ironhack.petshelter.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    /**
     * Save a new cat
     *
     * @param cat the cat to be saved
     */
    @PostMapping("/cats")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCat(@RequestBody Cat cat) {
        catService.save(cat);
    }
}
