package com.sriteja.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sriteja.api.model.EmployeeDetails;
import com.sriteja.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String insertEmployeeDetails(EmployeeDetails employeeDetails) {
		logger.info("Employee Details in Service Layer :: " + employeeDetails);
		employeeRepository.save(employeeDetails);
		return "Employee data sucessfully inserted.";
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByEmployeeId(String employeeId) {
		logger.info("Employee Id in service Layer :: " + employeeId );
		EmployeeDetails response = employeeRepository.findByEmployeeId(employeeId);
		return response;
	}

	@Override
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail) {
		logger.info("Employee Id = " + employeeId + "Employee Email= " + employeeEmail + " in Service Layer..");
		logger.info("Employee Details :: " + employeeDetails);
		String response = null;
		EmployeeDetails employee = employeeRepository.findByEmployeeIdAndEmployeeEmail(employeeId, employeeEmail);
		if (Optional.ofNullable(employee).isPresent()) {
			employee.setEmployeeSalary(employeeDetails.getEmployeeSalary());
			employee.setEmployeeMobile(employeeDetails.getEmployeeMobile());
			employeeRepository.save(employee);
			return response = "Employee Details updated successfully based on employee";

		} else {
			return response = "We don't have any matching data with Employee id " + employeeId + " Employee Email "
					+ employeeEmail;
		}

	
	}
	
	@Transactional
	@Override
	public String deleteEmployeedetailsBasedOnEmployeeMobile(String employeeMobile) {
		logger.info("Delete Employee Mobile :: " + employeeMobile);
		employeeRepository.deleteByEmployeeMobile(employeeMobile);
		return "Employee data sucessfully deleted by based on Employee Mobile";
	}
}
