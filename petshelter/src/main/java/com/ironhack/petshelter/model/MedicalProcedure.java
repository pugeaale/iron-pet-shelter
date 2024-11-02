package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MedicalProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String description;

    @ManyToOne
    @JoinColumn(name = "animalId")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinarianId")
    private Veterinarian veterinarian;
}
