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
     * Save a new employee
     *
     * @param employee the employee to be saved
     */
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAdopter(@RequestBody Employee employee) {
        employeeService.save(employee);
    }
}
