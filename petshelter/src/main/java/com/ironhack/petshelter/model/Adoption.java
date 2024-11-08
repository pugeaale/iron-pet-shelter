package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Adoption {

    @NotNull
    private LocalDate date;

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
