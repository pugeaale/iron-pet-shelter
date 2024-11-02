package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;

    @OneToOne(mappedBy = "animal")
    private Adoption adoption;

    Animal(String name) {
        this.name = name;
    }
}