package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.repository.AdopterRepository;
import com.ironhack.petshelter.service.AdopterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdopterServiceImpl implements AdopterService {

    private final AdopterRepository adopterRepository;

    @Transactional
    @Override
    public Adopter save(Adopter adopter) {
        log.info("Saving new adopter {} to the database", adopter.getLastName());
        return adopterRepository.save(adopter);
    }
}
