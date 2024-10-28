package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Shelter;
import com.ironhack.petshelter.repository.ShelterRepository;
import com.ironhack.petshelter.service.ShelterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShelterImpl implements ShelterService {

    private final ShelterRepository shelterRepository;

    @Override
    public Shelter save(Shelter shelter) {
        log.info("Saving new shelter {} to the database", shelter.getName());
        return shelterRepository.save(shelter);
    }
}
