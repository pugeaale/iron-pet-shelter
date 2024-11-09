package com.ironhack.petshelter.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Data transfer object for passing information for adding medical procedure
 */
@Data
public class MedicalProcedureDTO {

    @NotNull
    private Integer animalId;

    @NotNull
    private Long veterinarianId;

    @NotEmpty
    private String description;
}
