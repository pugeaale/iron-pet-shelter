package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Employee extends User {

    private String email;

    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;

}
