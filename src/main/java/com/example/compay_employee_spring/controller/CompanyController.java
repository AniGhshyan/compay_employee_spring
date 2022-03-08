package com.example.compay_employee_spring.controller;

import com.example.compay_employee_spring.entity.Company;
import com.example.compay_employee_spring.repository.CompanyRepository;
import com.example.compay_employee_spring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/company")
    public String companyPage(ModelMap map) {
        List<Company> companies = companyRepository.findAll();
        map.addAttribute("companies", companies);
        return "company";
    }

    @GetMapping("/saveCompany")
    public String addCompanyPage() {
        return "saveCompany";
    }

    @PostMapping("/saveCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyRepository.save(company);
        return "redirect:/company";
    }

    @GetMapping("/deleteCompany/{id}")
    @Transactional
    public String deleteCompany(@PathVariable("id") int id) {
        employeeRepository.deleteAllByCompanyId(id);
        companyRepository.deleteById(id);
        return "redirect:/company";

    }

}
