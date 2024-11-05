package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.dto.DogDTO;
import com.ironhack.petshelter.model.Dog;
import com.ironhack.petshelter.repository.DogRepository;
import com.ironhack.petshelter.service.DogService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    @Override
    public Dog update(Integer idInteger, DogDTO dogDTO) {
        log.info("update dog id:{}", idInteger);
        Optional<Dog> dog = dogRepository.findById(idInteger);
        if (dog.isPresent()) {
            dog.get().setOkDog(dogDTO.getOkDog());
            dog.get().setOkCat(dogDTO.getOkCat());
            dog.get().setOkChild(dogDTO.getOkChild());
            return dogRepository.save(dog.get());
        } else {
            return null;
        }
    }
}
