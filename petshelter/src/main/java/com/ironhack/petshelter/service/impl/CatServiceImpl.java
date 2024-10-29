package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Cat;
import com.ironhack.petshelter.repository.CatRepository;
import com.ironhack.petshelter.service.CatService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Transactional
    @Override
    public Cat save(Cat cat) {
        log.info("Saving new cat {} to the database", cat.getName());
        return catRepository.save(cat);
    }

    @Override
    public List<Cat> getCats() {
        log.info("Fetching all cats");
        return catRepository.findAll();
    }
}
