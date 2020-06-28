package com.bww.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bww.entity.Employee;
import com.bww.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Employee> retrieveEmployees() {
		return (List<Employee>) repository.findAll();
	}

	public Optional<Employee> retrieveEmployeeById(Long id) {
		return repository.findById(id);
	}

	public Employee createEmployee(Employee employee) {
		repository.save(employee);
		return employee;
	}

	public Optional<Employee> updateEmployee(Long id, Employee updateEmployee) {
		Optional<Employee> optExistsEmployee = repository.findById(id);
		if (!optExistsEmployee.isPresent()) {
			return optExistsEmployee;
		}
		updateEmployee.setId(id);
		return Optional.of(repository.save(updateEmployee));
	}

	public boolean deleteEmployee(Long id) {
		try {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
	}

}
