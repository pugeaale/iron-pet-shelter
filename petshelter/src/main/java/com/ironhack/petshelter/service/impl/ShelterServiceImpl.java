package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Shelter;
import com.ironhack.petshelter.repository.ShelterRepository;
import com.ironhack.petshelter.service.ShelterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {

    private final ShelterRepository shelterRepository;

    @Transactional
    @Override
    public Shelter save(Shelter shelter) {
        log.info("Saving new shelter {} to the database", shelter.getName());
        return shelterRepository.save(shelter);
    }

    @Override
    public List<Shelter> getShelters() {
        log.info("Fetching all shelters");
        return shelterRepository.findAll();
    }
}
