package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Dog;
import com.ironhack.petshelter.repository.DogRepository;
import com.ironhack.petshelter.service.DogService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Transactional
    @Override
    public Dog save(Dog dog) {
        log.info("Saving new dog {} to the database", dog.getName());
        return dogRepository.save(dog);
    }

    @Override
    public List<Dog> getDogs() {
        log.info("Fetching all dogs");
        return dogRepository.findAll();
    }
}
