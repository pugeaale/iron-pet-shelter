package com.ironhack.petshelter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Employee extends User {

    @NotEmpty(message = "employee email must be not empty")
    private String email;

    @Past(message = "employee dateOfBirth must be in the past")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "shelterId")
    private Shelter shelter;

}
