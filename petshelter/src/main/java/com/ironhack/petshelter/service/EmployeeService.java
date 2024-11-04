package com.ironhack.petshelter.service;

import com.ironhack.petshelter.dto.EmployeeDTO;
import com.ironhack.petshelter.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * This method is used to update a employee entity to the database.
     * @param employeeDTO the employee datas to update
     * @return the updated employee
     */
    Employee update(Integer id, EmployeeDTO employeeDTO);

    /**
     * This method is used to save a employee entity to the database.
     * @param employee the adopter to be saved
     * @return the saved employee
     */
    Employee save(Employee employee);

    /**
     * This method is used to retrieve all Employee entities from the database.
     *
     * @return a List of all Employee entities.
     */
    List<Employee> getEmployees();
    /**
     * This method is used to retrieve a employee by id from the database.
     * @param id the id of the employee to be retrieved
     * @return the retrieved employee
     */
    Employee getEmployeeById(Integer id);
}
