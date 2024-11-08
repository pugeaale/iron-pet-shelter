package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.EmployeeDTO;
import com.ironhack.petshelter.exception.ResourceNotFoundException;
import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Get a list of all Employees
     *
     * @return list of all Employees
     */
    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * Get a employee by id
     * @param id the id of the employee to be retrieved
     * @return the retrieved employee
     */
    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new ResourceNotFoundException("employee not found with id: " + id);
        }
        return ResponseEntity.ok().body(employee);
    }

    @PatchMapping("/employees/{id}")
    public Employee update(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.update(id, employeeDTO);
    }

    /**
     * Save a new employee
     * @param employee the employee to be saved
     * @return the employee created
     */
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody @Valid Employee employee) {
        return employeeService.save(employee);
    }
}
