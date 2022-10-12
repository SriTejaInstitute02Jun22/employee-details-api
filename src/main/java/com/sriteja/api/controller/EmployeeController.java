package com.sriteja.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sriteja.api.model.EmployeeDetails;
import com.sriteja.api.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add-emp-data")
	public String insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		logger.info(" Employee Data Adding :: " + employeeDetails);
		String response = employeeService.insertEmployeeDetails(employeeDetails);
		return response;
	}
	@GetMapping("/get-employee-data/{employeeId}")
	public EmployeeDetails getEmployeeDetailsById(@PathVariable int employeeId) {
		logger.info(" Get employee details by Employee Id :: " +employeeId);
		EmployeeDetails response = employeeService.getEmployeeDetailsByEmployeeId(employeeId);
		return response;
		
	}
	@PutMapping("update-employee-data/{employeeId}/{employeeEmail}")
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(@RequestBody EmployeeDetails employeeDetails,@PathVariable int employeeId,@PathVariable String employeeEmail) {
		logger.info(" Employee Details ::" + employeeDetails);
		logger.info("Employee Id ::" + employeeId+ "Employee Email ::" +employeeEmail+ "in service layer...");
		String response = employeeService.updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(employeeDetails,employeeId,employeeEmail);
		return response;
	}
	@DeleteMapping("/delete-emp-details/{employeeMobile}")
	public String deleteEmployeeDetailsBasedOnEmployeeMobile(@PathVariable String employeeMobile) {
		logger.info(" Employee Data delete by = " +employeeMobile);
		return employeeService.deleteEmployeeDataBasedOnEmployeeMobile(employeeMobile);
	}
	
	
	

}
