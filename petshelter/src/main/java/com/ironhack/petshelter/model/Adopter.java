package com.ironhack.petshelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Adopter extends User {

    @Email(message = "adopter email is invalid")
    private String email;

    private String phoneNumber;

    @OneToMany(mappedBy = "adopter")
    @JsonIgnore
    private List<Adoption> adoptions = new ArrayList<>();
}
