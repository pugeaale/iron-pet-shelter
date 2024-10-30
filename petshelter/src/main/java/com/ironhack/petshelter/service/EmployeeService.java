package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Employee;

public interface EmployeeService {

    /**
     * This method is used to save a employee entity to the database.
     * @param employee the adopter to be saved
     * @return the saved employee
     */
    Employee save(Employee employee);
}
