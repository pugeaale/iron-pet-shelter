package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Get a employee by id
     * @param id the id of the employee to be retrieved
     * @return the retrieved employee
     */
    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * Save a new employee
     *
     * @param employee the employee to be saved
     */
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }
}
