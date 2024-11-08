package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MedicalProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "animalId")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinarianId")
    private Veterinarian veterinarian;
}
