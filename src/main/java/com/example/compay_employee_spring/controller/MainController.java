package com.example.compay_employee_spring.controller;

import com.example.compay_employee_spring.repository.CompanyRepository;
import com.example.compay_employee_spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("${employee.upload.path}")
    private String imagePath;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String main() {
        return "main";
    }

}
