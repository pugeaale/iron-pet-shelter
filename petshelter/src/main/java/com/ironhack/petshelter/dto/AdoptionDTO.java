package com.ironhack.petshelter.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * Data transfer object for passing information for adding adoption
 */
@Data
public class AdoptionDTO {

    @NotNull
    private Integer animalId;

    @NotNull
    private Long adopterId;

    @NotNull
    private LocalDate date;
}
