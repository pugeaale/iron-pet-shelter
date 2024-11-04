package com.ironhack.petshelter.controller;

import com.ironhack.petshelter.dto.EmployeeDTO;
import com.ironhack.petshelter.dto.VeterinarianDTO;
import com.ironhack.petshelter.model.Adopter;
import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.model.Veterinarian;
import com.ironhack.petshelter.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PatchMapping("/employees/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.update(id, employeeDTO);
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
