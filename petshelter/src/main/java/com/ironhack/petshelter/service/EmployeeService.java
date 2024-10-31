package com.ironhack.petshelter.service;

import com.ironhack.petshelter.model.Employee;

public interface EmployeeService {

    /**
     * This method is used to save a employee entity to the database.
     * @param employee the adopter to be saved
     * @return the saved employee
     */
    Employee save(Employee employee);
    /**
     * This method is used to retrieve a employee by id from the database.
     * @param id the id of the employee to be retrieved
     * @return the retrieved employee
     */
    Employee getEmployeeById(Integer id);
}
