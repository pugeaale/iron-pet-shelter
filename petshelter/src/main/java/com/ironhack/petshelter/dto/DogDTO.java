package com.ironhack.petshelter.dto;

import lombok.Data;

/**
 * Data transfer object for passing information for update a dog
 */
@Data
public class DogDTO {

    private Boolean okDog;

    private  Boolean okCat;

    private Boolean okChild;
}
