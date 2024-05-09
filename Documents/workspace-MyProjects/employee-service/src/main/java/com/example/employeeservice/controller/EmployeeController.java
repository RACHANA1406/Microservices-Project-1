package com.example.employeeservice.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.model.EmployeeData;
import com.example.employeeservice.model.EmployeeResponse;
import com.example.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("employeeId") int employeeId){
		return employeeService.getEmployee(employeeId);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeData employeeData){
		return employeeService.addEmployee(employeeData);
	}

}
