package com.ironhack.petshelter.dto;

import lombok.Data;

import java.util.Optional;

/**
 * Data transfer object for passing information for update a vet
 */
@Data
public class VeterinarianDTO {

    private Optional<String> city = Optional.empty();;

    private Optional<String> phoneNumber = Optional.empty();;
}
