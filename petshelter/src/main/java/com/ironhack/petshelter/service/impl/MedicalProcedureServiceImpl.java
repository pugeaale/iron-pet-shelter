package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.MedicalProcedure;
import com.ironhack.petshelter.repository.MedicalProcedureRepository;
import com.ironhack.petshelter.service.MedicalProcedureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

    private final MedicalProcedureRepository medicalProcedureRepository;

    @Override
    public List<MedicalProcedure> getMedicalProcedures() {
        log.info("Fetching all medical procedures...");
        return medicalProcedureRepository.findAll();
    }
}
