package com.ironhack.petshelter.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cat extends Animal{

    private String breed;

    public Cat(String name) {
        super(name);
    }
}
