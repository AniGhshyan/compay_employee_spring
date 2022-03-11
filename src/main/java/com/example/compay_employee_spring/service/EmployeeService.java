package com.example.compay_employee_spring.service;

import com.example.compay_employee_spring.entity.Employee;
import com.example.compay_employee_spring.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllByCompanyId(int id) {
        employeeRepository.deleteAllByCompanyId(id);
    }
}
