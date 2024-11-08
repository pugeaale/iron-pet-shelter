package com.ironhack.petshelter.dto;

import lombok.Data;

import java.util.Optional;

/**
 * Data transfer object for passing information for update a dog
 */
@Data
public class DogDTO {

    private Optional<Boolean> okDog = Optional.empty();

    private Optional<Boolean> okCat = Optional.empty();

    private Optional<Boolean> okChild = Optional.empty();
}
