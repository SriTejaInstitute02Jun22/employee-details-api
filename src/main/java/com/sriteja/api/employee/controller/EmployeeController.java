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

/**
 * this call is using for employee details data
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

	// log4j to print the logs in the console.
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	/**
	 * add the employee details using post method
	 * @param employeeDetails
	 * @return string - response
	 */
	@PostMapping("/add-employee-details")
	public String insertEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {

		logger.info("Employee Details in Controller Layer :: " + employeeDetails);
		String response = employeeService.insertEmployeeDetails(employeeDetails);
		return response;

	}

	/**
	 * get the employee detailes based on employeeId
	 * @param employeeId
	 * @return
	 **/
	@GetMapping("/employee-details/{employeeId}")
	public EmployeeDetails getEmployeeDetailsByEmployeeId(@PathVariable() String employeeId) {
		logger.info("Employee Id in Controller Layer :: " + employeeId);
		EmployeeDetails response = employeeService.getEmployeeDetailsByEmployeeId(employeeId);
		return response;
	}

	/**
	 * update the Employee Details Based On EmployeeId And EmployeeEmail
	 * @param employeeDetails
	 * @param employeeId
	 * @param employeeEmail
	 * @return
	 **/
	@PutMapping("/update-employee-details/{employeeId}/{employeeEmail}")
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(@RequestBody EmployeeDetails employeeDetails,
			@PathVariable int employeeId, @PathVariable String employeeEmail) {
		logger.info("employee:: " + employeeDetails);
		logger.info("EmployeeId = " + employeeId + " EmployeeEmail =" + employeeEmail + " in controller Layer...");

		String response = employeeService.updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(employeeDetails,
				employeeId, employeeEmail); // method calling

		return response;
	}

	/**
	 * delete Employee Details Based On Employee Mobile
	 * @param employeeMobile
	 * @return
	 */
	@DeleteMapping("/delete-employee-details/{employeeMobile}")
	public String deleteEmployeeDetailsBasedOnEmployeeMobile(@PathVariable String employeeMobile) {

		return employeeService.deleteEmployeeDetailsBasedOnEmployeeMobile(employeeMobile);
	}
}