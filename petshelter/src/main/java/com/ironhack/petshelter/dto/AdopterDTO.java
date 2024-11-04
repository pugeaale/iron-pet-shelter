package com.ironhack.petshelter.dto;

import lombok.Data;

/**
 * Data transfer object for passing information for update an adopter
 */
@Data
public class AdopterDTO {

    private String email;

    private String phoneNumber;
}
