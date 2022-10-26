package com.sriteja.api.employee.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sriteja.api.bean.EmployeeDetails;
import com.sriteja.api.employee.model.Employee;
import com.sriteja.api.employee.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger Logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDetails insertEmployeeDetails(EmployeeDetails employeeDetails) {
		
		Logger.info("Employee Details in Service Layer :: " + employeeDetails);
		employeeRepository.save(this.setEmployeeEnityData(employeeDetails));

		// get employee data based on employee email and mobile number
		Employee employee = employeeRepository.getByEmployeeEmailAndEmployeeMobile(
				employeeDetails.getEmployeeEmail(), employeeDetails.getEmployeeMobile());
		
		return this.prepareJSONResponseData(employee);
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByOnEmployeeId(int employeeId) {
		Logger.info("Employee Id in Service Layer :: " + employeeId);
		Employee response = employeeRepository.findBY(employeeId);
		return this.prepareJSONResponseData(response);
	}

	@Override
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail) {
		Logger.info("Employee Id= " + employeeId + "Employee Email= " + employeeEmail + " in Service Layer..");
		Logger.info("Employee Details:: " + employeeDetails);
		String response = null;
		Employee employee = employeeRepository.findByEmployeeIdAndEmployeeEmail(employeeId, employeeEmail);
		if (Optional.ofNullable(employee).isPresent()) {
			employee.setEmployeeDep(employeeDetails.getEmployeeDep());
			employee.setEmployeeJoiningDate(employeeDetails.getEmployeeJoiningDate());
			employeeRepository.save(employee);
			return response = "Employee Details updated successfully based on employee";
		} else {
			return response = "We don't have any matching data with Employee Id " + employeeId + " Employee Email "
					+ employeeEmail + "...";
		}
	}

	@Transactional
	@Override
	public String deleteEmployeeDetailsBasedOnEmployeeMobile(String employeeMobile) {
		Logger.info("Delete Employee Mobile :: " + employeeMobile);
		employeeRepository.deleteByEmployeeMobile(employeeMobile);
		return "Employee data successfully deleted by based on Employee Mobile = " + employeeMobile;
	}
	
	//prepare the entity object data
	/**
	 * prepare the entity data from request json object
	 * @param employeeDetails - json requst object details
	 * 
	 * @return employee	- entity data
	 * **/
	private Employee setEmployeeEnityData(EmployeeDetails employeeDetails) {
		
		//create the employee object
		Employee employee = new Employee();
		employee.setEmployeeName(employeeDetails.getEmployeeName());
		employee.setEmployeeMobile(employeeDetails.getEmployeeMobile());
		employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
		employee.setEmployeeSalary(employeeDetails.getEmployeeSalary());
		employee.setEmployeeDep(employeeDetails.getEmployeeDep());
		employee.setEmployeeJoiningDate(employeeDetails.getEmployeeJoiningDate());
		return employee;
		
	}
	
	/**
	 * prepare the response json data
	 * @param employee - entity details
	 * 
	 * @return employeeDetails	- json response object
	 * **/
	private EmployeeDetails prepareJSONResponseData(Employee employee) {
		
		//create the employee object
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setEmployeeId(employee.getEmployeeId());
		employeeDetails.setEmployeeName(employee.getEmployeeName());
		employeeDetails.setEmployeeMobile(employee.getEmployeeMobile());
		employeeDetails.setEmployeeEmail(employee.getEmployeeEmail());
		employeeDetails.setEmployeeSalary(employee.getEmployeeSalary());
		employeeDetails.setEmployeeDep(employee.getEmployeeDep());
		employeeDetails.setEmployeeJoiningDate(employee.getEmployeeJoiningDate());
		return employeeDetails;
		
	}

}
