package com.ironhack.petshelter.dto;

import lombok.Data;

/**
 * Data transfer object for passing information for update a shelter
 */
@Data
public class ShelterDTO {

    private String city;

    private String phoneNumber;

    private String name;
}
