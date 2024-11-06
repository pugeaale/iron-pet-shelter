package com.ironhack.petshelter.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dog extends Animal {

    private Boolean okDog;

    private Boolean okCat;

    private Boolean okChild;

    @NotEmpty(message = "dog breed must be not empty")
    private String breed;

    public Dog(String name) {
        super(name);
    }
}
