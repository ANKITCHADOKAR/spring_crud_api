package com.ankit.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ankit.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);
	
	public Employee getEmployeeById(Long eid);
	
	public Employee updateEmployee(Long eid, Employee empDetails);
	
	public ResponseEntity<?> deleteEmployee(Long eid);
	
}
