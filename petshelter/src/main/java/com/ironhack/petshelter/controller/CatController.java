package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.CatDTO;
import com.ironhack.petshelter.exception.ResourceNotFoundException;
import com.ironhack.petshelter.model.Cat;
import com.ironhack.petshelter.model.User;
import com.ironhack.petshelter.service.CatService;
import com.ironhack.petshelter.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;
    private final UserService userService;


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
    public void saveCat(@RequestBody @Valid Cat cat, Principal principal) {
        User user = userService.getUser(principal.getName());
        log.info("post cat by user {}", user.getName());
        catService.save(cat);
    }

    @PatchMapping("/cats/{id}")
    public Cat update(@PathVariable Integer id, @RequestBody @Valid CatDTO catDTO) throws ResourceNotFoundException {
        return catService.update(id, catDTO);
    }
}
