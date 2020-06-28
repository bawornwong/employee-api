package com.bww.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bww.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping()
	public ResponseEntity<?> getEmployees() {
		List<Employee> employees = employeeService.retrieveEmployees();
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		Optional<Employee> optEmployee = employeeService.retrieveEmployeeById(id);
		if (!optEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optEmployee);
	}

	@PostMapping()
	public ResponseEntity<?> postEmployee(@RequestBody Employee body) {
		Employee employee = employeeService.createEmployee(body);
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putEmployee(@PathVariable Long id, @RequestBody Employee body) {
		Optional<?> optEmployee = employeeService.updateEmployee(id, body);
		if (!optEmployee.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optEmployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
		if (!employeeService.deleteEmployee(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
