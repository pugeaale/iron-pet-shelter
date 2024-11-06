package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.AdopterDTO;
import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.service.AdopterService;
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
     * Get a adopter by id
     * @param id the id of the adopter to be retrieved
     * @return the retrieved adopter
     */
    @GetMapping("/adopters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Adopter getAdopterById(@PathVariable Long id) {
        return adopterService.getAdopterById(id);
    }

    /**
     * Get a list of all Adopters
     *
     * @return list of all Adopters
     */
    @GetMapping("/adopters")
    @ResponseStatus(HttpStatus.OK)
    public List<Adopter> getShelters() {
        return adopterService.getAdopters();
    }

    @PatchMapping("/adopters/{id}")
    public Adopter update(@PathVariable Long id, @RequestBody AdopterDTO adopterDTO) {
        return adopterService.update(id, adopterDTO);
    }

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
