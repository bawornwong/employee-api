package com.bww.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bww.entity.Employee;
import com.bww.repository.EmployeeRepository;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				repository.save(new Employee("John", "Doe", "johndoe@email.com"));
				repository.save(new Employee("Jane", "Doe", "janedoe@email.com"));
			}
		};
	}
}
