package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @PostMapping("/add")
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("Inside saveEmployee of EmployeeController");
        return empService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long empId) {
        log.info("Inside getEmployeeById of EmployeeController");
        return empService.getEmployeeById(empId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        log.info("Inside getAllEmployees of EmployeeController");
        return empService.getAllEmployees();
    }

}
