package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class EmployeesController {
	
	@Autowired
	private EmployeeServices employeeServices;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/employees")
	public List<Employees> getAllEmployees() throws IOException{
		return employeeServices.saveEmployeesData();
	}
	/*public List<Employees> getAllEmployees(){
		return employeeServices.getAllEmployees();
	}
	*/
	@GetMapping("/employees/{employeeId}")
	public Optional<Employees> getEmployee(@PathVariable String employeeId){
		return employeeServices.getEmployee(employeeId);
	}
	
	@PostMapping("/register")
	public String addEmployee(@RequestBody Employees employee) {
		employeeServices.addEmployee(employee);
		return "Hi " + employee.getEmployeeName() + " you have registered successfully";
		
		
	}
	
	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employees employee, @PathVariable String employeeId) {
		employeeServices.updateEmployee(employeeId, employee);
	
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable String employeeId) {
		employeeServices.deleteEmployee(employeeId);
	}



}
