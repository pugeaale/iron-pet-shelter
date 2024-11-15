package com.ironhack.petshelter.service.impl;

import com.ironhack.petshelter.dto.EmployeeDTO;
import com.ironhack.petshelter.exception.ResourceNotFoundException;
import com.ironhack.petshelter.model.Employee;
import com.ironhack.petshelter.repository.EmployeeRepository;
import com.ironhack.petshelter.service.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public Employee update(Long id, EmployeeDTO employeeDTO) throws ResourceNotFoundException {
        log.info("employee update id:{}", id);
        Employee employee = getEmployeeById(id);
        if(employee == null) {
            throw new ResourceNotFoundException("employee not found with id " + id);
        }
        employee.setEmail(employeeDTO.getEmail());
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        log.info("Saving new employee {} to the database", employee.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee by id {}", id);
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> getEmployees() {
        log.info("Fetching all employees");
        return employeeRepository.findAll();
    }
}
