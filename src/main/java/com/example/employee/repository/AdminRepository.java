package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
    // Custom query method to find admin by username and password
    Admin findByUsernameAndPassword(String username, String password);
}
