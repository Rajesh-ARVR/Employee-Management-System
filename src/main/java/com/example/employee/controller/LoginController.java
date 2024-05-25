package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.employee.model.Admin;
import com.example.employee.repository.AdminRepository;

@RestController
public class LoginController {
	
	/* Note: You have to create an admin table that has a username and password.
	 * If you don't have one, create the table and insert the values into it.
	 * Afterwards, run this project. Enter your username and password, and you can perform CRUD operations on the employee details.
	 */

    @Autowired
    private AdminRepository adminRepository;

    // Display login page
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    // Handle login form submission
    @PostMapping("/login")
    public ModelAndView submit(@RequestParam("username") String username, @RequestParam("password") String password) {
        Admin foundAdmin = adminRepository.findByUsernameAndPassword(username, password);
        
        if (foundAdmin != null && foundAdmin.getUsername().equals(username) && foundAdmin.getPassword().equals(password)) {
            return new ModelAndView("redirect:/employees");
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("errorMessage", "Wrong Username or Password");
            return modelAndView;
        }
    }
}
