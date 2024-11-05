package com.ironhack.petshelter.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dog extends Animal {

    private Boolean okDog;

    private  Boolean okCat;

    private Boolean okChild;

    private String breed;

    public Dog(String name) {
        super(name);
    }
}
