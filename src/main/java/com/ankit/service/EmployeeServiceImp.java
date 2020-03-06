package com.ankit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ankit.exception.ResourceNotFoundException;
import com.ankit.model.Employee;
import com.ankit.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long empid) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empid));
	}

	@Override
	public Employee updateEmployee(Long empid, Employee empDetails) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(empid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empid));

		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());

		Employee updatedEmp = employeeRepository.save(employee);
		return updatedEmp;
	}

	@Override
	public ResponseEntity<?> deleteEmployee(Long empid) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(empid)
				.orElseThrow( ()-> new ResourceNotFoundException("Employee", "id", empid) );
		
		employeeRepository.delete(employee);
		return ResponseEntity.ok().build();
	}

}
