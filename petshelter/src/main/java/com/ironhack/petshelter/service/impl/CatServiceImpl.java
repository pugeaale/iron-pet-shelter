package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.model.Cat;
import com.ironhack.petshelter.repository.CatRepository;
import com.ironhack.petshelter.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    @Override
    public Cat save(Cat cat) {
        log.info("Saving new cat {} to the database", cat.getName());
        return catRepository.save(cat);
    }
}
