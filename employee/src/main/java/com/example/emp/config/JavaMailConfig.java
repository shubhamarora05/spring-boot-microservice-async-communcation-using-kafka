package com.example.emp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class JavaMailConfig {

	@Value("${spring.mail.host}")
	private String host;
	@Value("${spring.mail.port}")
	private int port;
	@Value("${spring.mail.username}")
	private String username;
	@Value("${spring.mail.password}")
	private String password;

	@Bean
	public JavaMailSenderImpl javaMailSenderConfig() {
		JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
		javaMail.setHost(host);
		javaMail.setPort(port);
		javaMail.setUsername(username);
		javaMail.setPassword(password);
		
		return javaMail;
	}
}
