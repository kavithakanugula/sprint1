package com.projectmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.entity.Employee;
import com.projectmanagement.exceptions.ResourceNotFoundException;
import com.projectmanagement.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping({ "/admin/get-employee-by-id/{employeeId}", "/employee/get-employee-by-id/{employeeId}" })
	public ResponseEntity<?> getEmployeeById(@PathVariable long employeeId) throws ResourceNotFoundException {
		return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
	}

	@PostMapping({ "/admin/add-employee", "employee/register-employee" })
	public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) throws Exception {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/admin/delete-employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}

	@GetMapping("/admin/get-all-employee")
	public ResponseEntity<?> getAllListOfEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@PutMapping({ "/admin/update-employee", "/employee/update-employee" })
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) throws ResourceNotFoundException {
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}

	@GetMapping({ "/admin/check-task-status by task-id/{taskId}", "/employee/check-task-status by task-id/{taskId}" })
	public String checkTaskStatus(@PathVariable long taskId) throws ResourceNotFoundException {
		return employeeService.checkTaskStatus(taskId);
	}

	@PostMapping("/employee/authenticate/{userName}/{password}")
	public ResponseEntity<?> authenticate(@PathVariable String userName, @PathVariable String password)
			throws Exception {
		return ResponseEntity.ok(employeeService.authenticateEmployee(userName, password));
	}

}
