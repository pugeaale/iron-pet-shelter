package com.ironhack.petshelter.dto;

import lombok.Data;

/**
 * Data transfer object for passing information for adding an employee to a shelter
 */
@Data
public class EmployeeToShelterDTO {

    private Long employeeId;

    private Long shelterId;
}
