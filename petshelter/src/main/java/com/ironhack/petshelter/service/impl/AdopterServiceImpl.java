package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.dto.AdopterDTO;
import com.ironhack.petshelter.exception.ResourceNotFoundException;
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
    public Adopter update(Long idInteger, AdopterDTO adopterDTO) throws ResourceNotFoundException {
        log.info("update adopter id:{}", idInteger);
        Adopter adopter = getAdopterById(idInteger);
        if(adopter == null) {
            throw new ResourceNotFoundException("adopter not found with id " + idInteger);
        }
        if(adopterDTO.getPhoneNumber().isPresent()) {
            adopter.setPhoneNumber(adopterDTO.getPhoneNumber().get());
        }
        if(adopterDTO.getEmail().isPresent()) {
            adopter.setEmail(adopterDTO.getEmail().get());
        }
        return adopterRepository.save(adopter);
    }

    @Transactional
    @Override
    public Adopter save(Adopter adopter) {
        log.info("Saving new adopter {} to the database", adopter.getName());
        return adopterRepository.save(adopter);
    }

    @Override
    public List<Adopter> getAdopters() {
        log.info("Fetching all adopters");
        return adopterRepository.findAll();
    }

    @Override
    public Adopter getAdopterById(Long id) {
        log.info("Fetching adopter by id {}", id);
        Optional<Adopter> adopter = adopterRepository.findById(id);
        return adopter.orElse(null);
    }
}
