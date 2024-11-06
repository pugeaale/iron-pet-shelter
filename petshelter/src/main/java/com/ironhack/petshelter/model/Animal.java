package com.ironhack.petshelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "animal name must be not empty")
    private String name;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;

    @OneToOne(mappedBy = "animal")
    private Adoption adoption;

    @OneToMany(mappedBy = "animal")
    @JsonIgnore
    private List<MedicalProcedure> medicalProcedures = new ArrayList<>();

    Animal(String name) {
        this.name = name;
    }
}