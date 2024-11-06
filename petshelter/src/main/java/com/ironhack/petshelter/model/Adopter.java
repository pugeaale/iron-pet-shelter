package com.ironhack.petshelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Adopter extends User {

    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "adopter")
    @JsonIgnore
    private List<Adoption> adoptions = new ArrayList<>();
}
