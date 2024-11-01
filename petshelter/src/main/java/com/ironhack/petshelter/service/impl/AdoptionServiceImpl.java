package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Adoption;
import com.ironhack.petshelter.repository.AdoptionRepository;
import com.ironhack.petshelter.service.AdoptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;

    @Override
    public List<Adoption> getAdoptions() {
        log.info("Fetching all Adoptions");
        return adoptionRepository.findAll();
    }

}
