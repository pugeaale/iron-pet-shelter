package com.ironhack.petshelter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Data
@NoArgsConstructor
public class Shelter extends User {

    @NotEmpty
    private String city;

    @Pattern(regexp = "^\\+?[0-9 .\\-()]{7,15}$", message = "shelter phone number is invalid")
    private String phoneNumber;

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();
}
