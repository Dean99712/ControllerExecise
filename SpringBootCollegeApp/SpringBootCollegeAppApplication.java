package com.lecture.SpringBootCollegeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.lecture.SpringBootCollegeApp.repository")
@EntityScan("com.lecture.SpringBootCollegeApp.model")
@EnableJpaAuditing(auditorAwareRef = "AuditAwareBean")
public class SpringBootCollegeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCollegeAppApplication.class, args);
	}

}
