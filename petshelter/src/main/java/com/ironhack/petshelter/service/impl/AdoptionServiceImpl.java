package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.model.Adoption;
import com.ironhack.petshelter.model.Animal;
import com.ironhack.petshelter.repository.AdoptionRepository;
import com.ironhack.petshelter.service.AdopterService;
import com.ironhack.petshelter.service.AdoptionService;
import com.ironhack.petshelter.service.AnimalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final AdopterService adopterService;
    private final AnimalService animalService;

    @Override
    public List<Adoption> getAdoptions() {
        log.info("Fetching all Adoptions");
        return adoptionRepository.findAll();
    }

    @Transactional
    @Override
    public Adoption create(Integer animalId, Integer adopterId) {
        log.info("Saving new Adoption to the database [animalId:"+animalId+", adopterId:"+adopterId+"]");
        Animal animal = animalService.getAnimalById(animalId);
        if( animal == null )
            return null;
        Adopter adopter = adopterService.getAdopterById(adopterId);
        if( adopter == null )
            return null;
        Adoption adoption = new Adoption();
        adoption.setAnimal(animal);
        adoption.setAdopter(adopter);
        return adoptionRepository.save(adoption);
    }

}
