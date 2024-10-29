package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Cat;
import com.ironhack.petshelter.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    /**
     * Get a list of all cats
     *
     * @return list of all cats
     */
    @GetMapping("/cats")
    @ResponseStatus(HttpStatus.OK)
    public List<Cat> getCats() {
        return catService.getCats();
    }

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
