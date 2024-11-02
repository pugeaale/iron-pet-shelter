package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "adopterId")
    private Adopter adopter;

    @OneToOne
    @JoinColumn(name = "animalId")
    private Animal animal;
}
