package com.ankit.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.ankit.model.Employee;
import com.ankit.service.EmployeeServiceImp;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImp employeeServiceImp;
	
	
	@GetMapping("/allemp")
	public List<Employee> getAllEmployees(){
		System.out.println("calling 1 api");
		return employeeServiceImp.getAllEmployees();
	}
	
	@PostMapping("/postemp")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		
		return employeeServiceImp.createEmployee(employee);
		
	}
	
	
	@GetMapping("/getemp/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Long empid) {
		
		return employeeServiceImp.getEmployeeById(empid);
		
	}
	
	
	@PutMapping("/putemp/{id}")
	public Employee updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid@RequestBody Employee empDetails ) {
				
		return employeeServiceImp.updateEmployee(empid, empDetails);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value="id") Long empid){
		
		return employeeServiceImp.deleteEmployee(empid);
	}
	
	
	
	
}	
