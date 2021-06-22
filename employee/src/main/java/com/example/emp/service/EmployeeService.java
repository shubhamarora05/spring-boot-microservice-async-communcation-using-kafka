package com.example.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.example.dept.dto.MessageDetails;
import com.example.emp.entity.Employee;
import com.example.emp.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepository;
    
    @Autowired
    private JavaMailSenderImpl javaMailSenderConfig;

    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveEmployee of EmployeeService");
        return empRepository.save(employee);
    }

    public Employee getEmployeeById(Long empId) {
        log.info("Inside getEmployeeById of EmployeeService");
        return empRepository.findById(empId).orElseThrow();
    }

	public List<Employee> getAllEmployees() {
		log.info("Inside getAllEmployees of EmployeeService");
		return empRepository.findAll();
	}
	
	public void sendMail(MessageDetails message, String email) {
		log.info("Sending email");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(message.getFrom());
		mailMessage.setTo(email);
		mailMessage.setSubject(message.getSubject());
		mailMessage.setText(message.getBody());
		
		javaMailSenderConfig.send(mailMessage);
		log.info("Email Sent");
	}
}