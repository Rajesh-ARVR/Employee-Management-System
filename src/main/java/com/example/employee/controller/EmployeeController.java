package com.example.employee.controller;

import com.example.employee.exception.UniqueConstraintViolationException;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    // Method to display the home page
    @GetMapping
    public ModelAndView viewHomePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("employees", employeeService.getAllEmployees());
        return modelAndView;
    }

    // Method to show form for adding a new employee
    @GetMapping("/showNewEmployeeForm")
    public ModelAndView showNewEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("new-employee");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    
    // Method to save a new employee
    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        try {
            employeeService.saveEmployee(employee);
            return new ModelAndView("redirect:/employees");
        } catch (UniqueConstraintViolationException ex) {
            ModelAndView modelAndView = new ModelAndView("new-employee");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("errorMessage", ex.getMessage());
            return modelAndView;
        }
    }

    // Method to show form for updating an employee
    @GetMapping("/showFormForUpdate/{id}")
    public ModelAndView showFormForUpdate(@PathVariable(value = "id") long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return new ModelAndView("redirect:/employees");
        }
        // Split the skills string into an array
        String[] employeeSkills = employee.getEmployeeSkills().split(",");
        ModelAndView modelAndView = new ModelAndView("update-employee");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("employeeSkills", employeeSkills); // Add employee skills to the model
        return modelAndView;
    }

    // Method to update an employee
    @PostMapping("/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee) {
        try {
            employeeService.updateEmployee(employee);
            return new ModelAndView("redirect:/employees");
        } catch (UniqueConstraintViolationException ex) {
            ModelAndView modelAndView = new ModelAndView("update-employee");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("employeeSkills", employee.getEmployeeSkills().split(","));
            modelAndView.addObject("errorMessage", ex.getMessage());
            return modelAndView;
        }
    }

    // Method to delete an employee
    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return new ModelAndView("redirect:/employees");
    }
}
