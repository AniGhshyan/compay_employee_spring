package com.example.compay_employee_spring.controller;

import com.example.compay_employee_spring.entity.Company;
import com.example.compay_employee_spring.repository.CompanyRepository;
import com.example.compay_employee_spring.repository.EmployeeRepository;
import com.example.compay_employee_spring.service.CompanyService;
import com.example.compay_employee_spring.service.EmployeeService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final EmployeeService employeeService;


    @GetMapping("/company")
    public String companyPage(ModelMap map) {
        map.addAttribute("companies", companyService.findAll());
        return "company";
    }

    @GetMapping("/saveCompany")
    public String addCompanyPage() {
        return "saveCompany";
    }

    @PostMapping("/saveCompany")
    public String addCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/company";
    }

    @GetMapping("/deleteCompany/{id}")
    @Transactional
    public String deleteCompany(@PathVariable("id") int id) {
        employeeService.deleteAllByCompanyId(id);
        companyService.deleteById(id);
        return "redirect:/company";

    }

}
