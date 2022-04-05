package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Scheduled(fixedRate = 10000L)
	public List<Employees> saveEmployeesData() throws IOException {
		
		BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\lenovo\\Desktop/Book1.csv"));
		
		String line= "";
		while((line=br.readLine())!=null) {
			String [] data = line.split(",");
			Employees e = new Employees();
			e.setEmployeeId(data[0]);
			e.setEmployeeName(data[1]);
			e.setEmployeeEmail(data[2]);
			e.setEmployeeExperience(data[3]);
			employeeRepository.save(e);
			
		}
		List<Employees> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		System.out.println("Updated List " + new Date());
		return employees;
		
		
	}
	
	
	public List<Employees> getAllEmployees(){
		List<Employees> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
		
	}
	public Optional<Employees> getEmployee(String employeeId) {
		return employeeRepository.findById(employeeId);
	}
	
	public void addEmployee(Employees employee) {
		employeeRepository.save(employee);
		
	}
	public void updateEmployee(String employeeId, Employees employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(String employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
