package com.example.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
// Method to create table and mention unique key columns
@Table(name="employees", uniqueConstraints={
        @UniqueConstraint(name = "unique_employee_email_phone", columnNames ={"employee_email","employee_phone_number"})
     })
public class Employee {
    // Mentioning column names
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long id;
    
    @Column(name="employee_name", nullable = false)
    private String employeeName;
    
    @Column(name="employee_email", nullable = false, unique = true)
    private String employeeEmail;
    
    @Column(name="employee_phone_number", nullable = false, unique = true)
    private String employeePhoneNumber;
    
    @Column(name="employee_department", nullable = false)
    private String employeeDepartment;
    
    @Column(name="employee_skills", nullable = false)
    private String employeeSkills;
    
    // Generating constructor
    public Employee(Long id, String employeeName, String employeeEmail, String employeePhoneNumber,
            String employeeDepartment, String employeeSkills) {
        super();
        this.id = id;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeDepartment = employeeDepartment;
        this.employeeSkills = employeeSkills;
    }

    public Employee() {
        super();
    }

    //Generating getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeSkills() {
        return employeeSkills;
    }

    public void setEmployeeSkills(String employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", employeeName=" + employeeName + ", employeeEmail=" + employeeEmail
                + ", employeePhoneNumber=" + employeePhoneNumber + ", employeeDepartment=" + employeeDepartment
                + ", employeeSkills=" + employeeSkills + "]";
    }
}
