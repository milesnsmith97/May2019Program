package com.mastek.training.hrapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mastek.training.hrapp.apis.EmployeeService;
import com.mastek.training.hrapp.entities.Employee;

@SpringBootApplication
public class HrAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(HrAppApplication.class, args);
	}

}
