package com.example.emp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.dept.dto.Notification;
import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeConsumerConfiguration {

	@Autowired
	EmployeeService service;
	
	@KafkaListener(topics = "myTopic", groupId = "myGroup")
	public void consume(Notification notification) {
		log.info("Consumed Message: "+notification);
		Employee emp = service.getEmployeeById(notification.getEmployeeId());
		service.sendMail(notification.getMessageDetails(), emp.getEmail());
	}
}
