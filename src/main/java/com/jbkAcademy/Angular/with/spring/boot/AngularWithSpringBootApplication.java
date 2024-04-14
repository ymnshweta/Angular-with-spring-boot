package com.jbkAcademy.Angular.with.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import jakarta.persistence.Entity;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.jbkAcademy.Angular.with.spring.boot")
public class AngularWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularWithSpringBootApplication.class, args);
		System.out.println(" Angular");
	}

}
