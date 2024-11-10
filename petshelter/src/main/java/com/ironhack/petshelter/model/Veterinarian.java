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
@PrimaryKeyJoinColumn(name="id")
@NoArgsConstructor
public class Veterinarian extends User {

    @NotEmpty
    private String city;

    @NotEmpty
    private String phoneNumber;

    @OneToMany(mappedBy = "veterinarian")
    @JsonIgnore
    private List<MedicalProcedure> medicalProcedures = new ArrayList<>();
}
