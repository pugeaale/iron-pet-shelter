package com.ironhack.petshelter.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Data transfer object for passing information for update a cat
 */
@Data
public class CatDTO {

    @NotEmpty(message = "cat breed must be not empty")
    private String breed;
}
