package com.example.dept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.dept.dto.Notification;
import com.example.dept.entity.Department;
import com.example.dept.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Value("${kafka.topic.name}")
	private String topic;

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
	private KafkaTemplate<String, Notification> kafkaTemplate;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById of DepartmentService");
    	return departmentRepository.findById(departmentId).orElseThrow();
    }

	public List<Department> findAllDepartments() {
		log.info("Inside findAllDepartments of DepartmentService");
		return departmentRepository.findAll();	
	}

	public void sendNotificationToEmployees(Notification notification, Department dept) {
		log.info("sending message!!!");
		notification.getMessageDetails().setBody(notification.getMessageDetails().getBody() + " \r\n " +dept);
		kafkaTemplate.send(topic, notification);
		log.info("Message sent!!!");
	}

}

