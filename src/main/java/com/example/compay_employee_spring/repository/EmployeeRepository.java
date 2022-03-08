package com.example.compay_employee_spring.repository;

import com.example.compay_employee_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeesByCompanyId(int id);

    void deleteAllByCompanyId(int id);
}
