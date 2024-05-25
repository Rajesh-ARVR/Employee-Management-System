package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//Finding Email
    Employee findByEmployeeEmail(String email);
    //Finding Phone number
    Employee findByEmployeePhoneNumber(String phoneNumber);
}
