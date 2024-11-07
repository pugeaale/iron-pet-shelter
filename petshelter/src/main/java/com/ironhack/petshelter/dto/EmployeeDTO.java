package com.ironhack.petshelter.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

/**
 * Data transfer object for passing information for update an employee
 */
@Data
public class EmployeeDTO {

    @Email(message = "employee email is invalid")
    private String email;
}
