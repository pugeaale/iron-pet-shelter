package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.repository.AdopterRepository;
import com.ironhack.petshelter.service.AdopterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Adopter> getAdopters() {
        log.info("Fetching all adopters");
        return adopterRepository.findAll();
    }

    @Override
    public Adopter getAdopterById(Integer id) {
        log.info("Fetching adopter by id {}", id);
        Optional<Adopter> adopter = adopterRepository.findById(id);
        return adopter.orElse(null);
    }
}
