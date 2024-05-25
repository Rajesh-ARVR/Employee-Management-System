package com.example.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.example.employee.exception.UniqueConstraintViolationException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Method to get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Method to save an employee
    public Employee saveEmployee(Employee employee) {
        validateEmployee(employee);
        return employeeRepository.save(employee);
    }

    // Method to get an employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Method to delete an employee by ID
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }


    // Method to update an employee
    public Employee updateEmployee(Employee updatedEmployee) {
        validateEmployee(updatedEmployee);
        return employeeRepository.save(updatedEmployee);
    }

    // Method to validate employee data
    private void validateEmployee(Employee employee) {
        if (employee.getEmployeePhoneNumber().length() != 10) {
            throw new UniqueConstraintViolationException("Phone number must be 10 digits long.");
        }
        
        Employee existingEmployeeByEmail = employeeRepository.findByEmployeeEmail(employee.getEmployeeEmail());
        if (existingEmployeeByEmail != null && !existingEmployeeByEmail.getId().equals(employee.getId())) {
            throw new UniqueConstraintViolationException("Email already exists.");
        }

        Employee existingEmployeeByPhoneNumber = employeeRepository.findByEmployeePhoneNumber(employee.getEmployeePhoneNumber());
        if (existingEmployeeByPhoneNumber != null && !existingEmployeeByPhoneNumber.getId().equals(employee.getId())) {
            throw new UniqueConstraintViolationException("Phone number already exists.");
        }
    }


}
