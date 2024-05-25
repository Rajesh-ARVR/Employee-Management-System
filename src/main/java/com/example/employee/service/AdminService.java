package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.model.Admin;
import com.example.employee.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Service method to get Admin by username
    public Admin getAdminByUsername(String username) {
        return adminRepository.findById(username).orElse(null);
    }
}
