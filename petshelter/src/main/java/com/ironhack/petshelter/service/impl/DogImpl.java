package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Dog;
import com.ironhack.petshelter.repository.DogRepository;
import com.ironhack.petshelter.service.DogService;
import com.ironhack.petshelter.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DogImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public Dog save(Dog dog) {
        log.info("Saving new dog {} to the database", dog.getName());
        return dogRepository.save(dog);
    }
}
