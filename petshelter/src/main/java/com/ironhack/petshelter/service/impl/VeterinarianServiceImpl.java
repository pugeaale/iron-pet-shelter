package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Veterinarian;
import com.ironhack.petshelter.repository.VeterinarianRepository;
import com.ironhack.petshelter.service.VeterinarianService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VeterinarianServiceImpl implements VeterinarianService {

    private final VeterinarianRepository veterinarianRepository;

    @Transactional
    @Override
    public Veterinarian save(Veterinarian veterinarian) {
        log.info("Saving new veterinarian {} to the database", veterinarian.getLastName());
        return veterinarianRepository.save(veterinarian);
    }

    @Override
    public List<Veterinarian> getVeterinarians() {
        log.info("Fetching all Veterinarians");
        return veterinarianRepository.findAll();
    }

    @Override
    public Veterinarian getVeterinarianById(Integer id) {
        log.info("Fetching Veterinarian by id {}", id);
        Optional<Veterinarian> veterinarian = veterinarianRepository.findById(id);
        return veterinarian.orElse(null);
    }
}
