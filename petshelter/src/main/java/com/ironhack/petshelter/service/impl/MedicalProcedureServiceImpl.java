package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.*;
import com.ironhack.petshelter.repository.MedicalProcedureRepository;
import com.ironhack.petshelter.service.AnimalService;
import com.ironhack.petshelter.service.MedicalProcedureService;
import com.ironhack.petshelter.service.VeterinarianService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

    private final MedicalProcedureRepository medicalProcedureRepository;
    private final VeterinarianService veterinarianService;
    private final AnimalService animalService;

    @Override
    public List<MedicalProcedure> getMedicalProcedures() {
        log.info("Fetching all medical procedures...");
        return medicalProcedureRepository.findAll();
    }

    @Override
    public List<MedicalProcedure> getMedicalProceduresByAnimal(Integer animalId) {
        log.info("Fetching all medical procedures by animal id: {}", animalId);
        return medicalProcedureRepository.findMedicalProcedureByAnimal_Id(animalId);
    }

    @Override
    public List<MedicalProcedure> getMedicalProceduresByVeterinarian(Long veterinarianId) {
        log.info("Fetching all medical procedures by veterinarian id: {}", veterinarianId);
        return medicalProcedureRepository.findMedicalProcedureByVeterinarianId(veterinarianId);
    }

    @Transactional
    @Override
    public MedicalProcedure create(Integer animalId, Long veterinarianId) {
        log.info("Saving new Medical Procedure to the database [animalId:"+animalId+", veterinarianId:"+veterinarianId+"]");
        Animal animal = animalService.getAnimalById(animalId);
        if( animal == null )
            return null;
        Veterinarian veterinarian = veterinarianService.getVeterinarianById(veterinarianId);
        if( veterinarian == null )
            return null;
        MedicalProcedure medicalProcedure = new MedicalProcedure();
        medicalProcedure.setAnimal(animal);
        medicalProcedure.setVeterinarian(veterinarian);
        animal.getMedicalProcedures().add(medicalProcedure);
        animalService.saveAnimal(animal);
        veterinarian.getMedicalProcedures().add(medicalProcedure);
        veterinarianService.save(veterinarian);
        return medicalProcedureRepository.save(medicalProcedure);
    }
}
