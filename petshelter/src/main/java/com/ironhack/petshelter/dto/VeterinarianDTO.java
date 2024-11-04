package com.ironhack.petshelter.dto;

import lombok.Data;

/**
 * Data transfer object for passing information for update a vet
 */
@Data
public class VeterinarianDTO {

    private String city;

    private String phoneNumber;
}
