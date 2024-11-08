package com.ironhack.petshelter.dto;

import lombok.Data;

import java.util.Optional;

/**
 * Data transfer object for passing information for update an adopter
 */
@Data
public class AdopterDTO {

    private Optional<String> email = Optional.empty();

    private Optional<String> phoneNumber = Optional.empty();
}
