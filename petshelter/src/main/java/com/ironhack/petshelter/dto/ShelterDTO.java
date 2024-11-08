package com.ironhack.petshelter.dto;

import lombok.Data;

import java.util.Optional;

/**
 * Data transfer object for passing information for update a shelter
 */
@Data
public class ShelterDTO {

    private Optional<String> city = Optional.empty();

    private Optional<String> phoneNumber = Optional.empty();

    private Optional<String> name = Optional.empty();
}
