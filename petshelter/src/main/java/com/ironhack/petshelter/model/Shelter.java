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
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String city;

    private String phoneNumber;

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(mappedBy = "shelter")
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();
}
