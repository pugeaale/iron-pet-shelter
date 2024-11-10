package com.ironhack.petshelter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@PrimaryKeyJoinColumn(name="id")
@NoArgsConstructor
public class Cat extends Animal {

    @NotEmpty
    private String breed;

    public Cat(String name) {
        super(name);
    }
}
