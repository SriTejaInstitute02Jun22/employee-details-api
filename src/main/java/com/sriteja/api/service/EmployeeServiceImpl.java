package com.sriteja.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.sriteja.api.model.EmployeeDetails;
import com.sriteja.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public String insertEmployeeDetails(EmployeeDetails employeeDetails) {
		logger.info("Data Inserted :: " + employeeDetails);
		employeeRepository.save(employeeDetails);
		return null;
	}
	@Override
	public EmployeeDetails getEmployeeDetailsByEmployeeId(int employeeId) {
		logger.info("Employee Data in service layer ::" + employeeId);
		EmployeeDetails response = employeeRepository.findBy(employeeId);
		return null;
	}
	@Override
	public String updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(EmployeeDetails employeeDetails,
			int employeeId, String employeeEmail) {
		logger.info(" Employee details ::" + employeeDetails);
		logger.info("Name = " +employeeId+ "Employee Email = " + employeeEmail+" in service layer ...");
		String response = null;
		EmployeeDetails emp = employeeRepository.updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(employeeId,employeeEmail);
		if(Optional.ofNullable(emp).isPresent()) {
			emp.setEmployeeName(employeeDetails.getEmployeeName());
			emp.setEmployeeMobile(employeeDetails.getEmployeeMobile());
			employeeRepository.save(emp);
			return response = " Employee Data successfully Updated By Emp Id :"+employeeId+" Employee Email " +employeeEmail+ ".....";
		}else {
			return response = " Employee Data location and company doesnt have ";
		}
	}
	@Transactional
	@Override
	public String deleteEmployeeDataBasedOnEmployeeMobile(String employeeMobile) {
		logger.info("Delete Employee Mobile :: " +employeeMobile);
		employeeRepository.deleteByEmployeeMobile(employeeMobile);
		return "Employee Data successfully deleted by Employee Mobile::"+employeeMobile;
	}
	


}
