package com.sriteja.api.employee.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sriteja.api.employee.model.EmployeeDetails;
import com.sriteja.api.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger Logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String insertEmployeeDetails(EmployeeDetails employeeDetails) {
		Logger.info("Employee Details in Service Layer :: " + employeeDetails);
		employeeRepository.save(employeeDetails);
		return "Employee Details in Service Layer.";
	}

	@Override
	public EmployeeDetails getEmployeeDetailsByOnEmployeeId(int employeeId) {
		Logger.info("Employee Id in Service Layer :: " + employeeId);
		EmployeeDetails response = employeeRepository.findBY(employeeId);
		return response;
	}

	@Override
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail) {
		Logger.info("Employee Id= " + employeeId + "Employee Email= " + employeeEmail + " in Service Layer..");
		Logger.info("Employee Details:: " + employeeDetails);
		String response = null;
		EmployeeDetails employee = employeeRepository.findByEmployeeIdAndEmployeeEmail(employeeId, employeeEmail);
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

}
