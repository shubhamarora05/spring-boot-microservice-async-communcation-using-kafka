package com.example.dept.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dept.dto.Notification;
import com.example.dept.entity.Department;
import com.example.dept.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @GetMapping("/all")
    public List<Department> findAllDepartments() {
        log.info("Inside findAllDepartments method of DepartmentController");
        return departmentService.findAllDepartments();
    }

    @PostMapping("/sendNotification")
    public String sendNotification(@RequestBody Notification notification) {
    	log.info("Inside sendNotification method of DepartmentController");
    	Department dept = departmentService.findDepartmentById(notification.getDepartmentId());
    	departmentService.sendNotificationToEmployees(notification, dept);
    	return "Message sent Successfully!!";
    }

}
