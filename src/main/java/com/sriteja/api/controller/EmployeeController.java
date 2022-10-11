package com.sriteja.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sriteja.api.model.EmployeeDetails;
import com.sriteja.api.service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
	 * To insert the data into employee table
	 * @param employeeDetails
	 * @return response
	 */
	@PostMapping("/add-employee-details")
	public String insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		logger.info("Added new employee details in Controller Layer : " +employeeDetails);
		return employeeService.insertEmployeeDetails(employeeDetails);
	
	}
	/**
	 * To get the employee details based on company name
	 * @param empCompany
	 * @return employee details
	 */
	
	@GetMapping("/get-employee-details/{empCompany}")
	public String getEmployeeDetails(@PathVariable String empCompany) {
		logger.info("Employee Details in controller layer : " +empCompany);
		return employeeService.getEmployeeDetails(empCompany);
		
	}
	

}
