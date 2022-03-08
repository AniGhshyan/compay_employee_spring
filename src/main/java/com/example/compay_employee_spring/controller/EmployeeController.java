package com.example.compay_employee_spring.controller;

import com.example.compay_employee_spring.entity.Employee;
import com.example.compay_employee_spring.repository.CompanyRepository;
import com.example.compay_employee_spring.repository.EmployeeRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Value("${employee.upload.path}")
    private String imagePath;

    @GetMapping("/employee")
    public String companyPage(ModelMap map) {
        List<Employee> employees = employeeRepository.findAll();
        map.addAttribute("employees", employees);
        return "employee";
    }

    @GetMapping("/saveEmployee")
    public String addCompanyPage(ModelMap map) {
        map.addAttribute("companies", companyRepository.findAll());
        return "saveEmployee";
    }

    @PostMapping("/saveEmployee")
    public String addEmployee(@ModelAttribute Employee employee, @RequestParam("picture") MultipartFile uploadedFile) throws IOException {
        if (!uploadedFile.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + uploadedFile.getOriginalFilename();
            File newFile = new File(imagePath + fileName);
            uploadedFile.transferTo(newFile);
            employee.setPictureUrl(fileName);
        }
        employeeRepository.save(employee);
        return "redirect:/employee";
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("picName") String picName) throws IOException {
        InputStream inputStream = new FileInputStream(imagePath + picName);
        return IOUtils.toByteArray(inputStream);
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteCompany(@PathVariable("id") int id) {
        employeeRepository.deleteById(id);
        return "redirect:/employee";
    }

}
