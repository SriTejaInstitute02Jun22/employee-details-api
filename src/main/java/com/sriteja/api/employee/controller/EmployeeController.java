package com.sriteja.api.employee.controller;

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

import com.sriteja.api.employee.model.EmployeeDetails;
import com.sriteja.api.employee.service.EmployeeService;

/*
 * this annotation is using for call company details
 * 
 * 
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {
	// loggers to print the logs in the console
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	/**
	 * 
	 * insert the employee details
	 * 
	 * @return response
	 */

	@PostMapping("/add-employee-details")
	public String insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		logger.info("Employee Details in Controller Layer = " + employeeDetails);
		String response = employeeService.insertEmployeeDetails(employeeDetails);
		return response;
	}

	/**
	 * get the employee details
	 * 
	 * @param employeeId
	 * @return response
	 */

	@GetMapping("/get-employee-details-based-on-employeeid/{employeeId}")
	public EmployeeDetails getEmployeeDetailsByOnEmployeeId(@PathVariable int employeeId) {
		logger.info("Employee Id in Controller Layer :: " + employeeId);
		EmployeeDetails response = employeeService.getEmployeeDetailsByOnEmployeeId(employeeId);
		return response;
	}

	/**
	 * this method update EmployeeDetails Based On EmployeeId And Employee Email
	 * 
	 * @param employeeDetails
	 * @param employeeId
	 * @param employeeEmail
	 * @return response message
	 */

	@PutMapping("/update-employee-details/{employeeId}/{employeeEmail}")
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(@RequestBody EmployeeDetails employeeDetails,
			@PathVariable int employeeId, @PathVariable String employeeEmail) {
		logger.info("Employee Id = " + employeeId + " Employee Email = " + employeeEmail + " in Controller Layer..");
		logger.info("Employee Details ::" + employeeDetails);
		String response = employeeService.updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(employeeDetails,
				employeeId, employeeEmail);
		return response;
	}

	/**
	 * this method is using to delete the employee details by employee mobile data
	 * 
	 * @param employeeMobile
	 * @return return
	 */

	@DeleteMapping("/delete-employee-details/{employeeMobile}")
	public String deleteEmployeeDetailsBasedOnEmployeeMobile(@PathVariable String employeeMobile) {
		logger.info("Employee Mobile :: " + employeeMobile);
		return employeeService.deleteEmployeeDetailsBasedOnEmployeeMobile(employeeMobile);
	}
}
