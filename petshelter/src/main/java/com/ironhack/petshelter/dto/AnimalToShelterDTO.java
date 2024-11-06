package com.ironhack.petshelter.dto;

import lombok.Data;

/**
 * Data transfer object for passing information for adding an animal to a shelter
 */
@Data
public class AnimalToShelterDTO {

    private Integer animalId;

    private Long shelterId;
}
