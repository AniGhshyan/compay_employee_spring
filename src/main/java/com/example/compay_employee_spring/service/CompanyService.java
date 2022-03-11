package com.example.compay_employee_spring.service;

import com.example.compay_employee_spring.entity.Company;
import com.example.compay_employee_spring.repository.CompanyRepository;
import com.example.compay_employee_spring.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }
}
