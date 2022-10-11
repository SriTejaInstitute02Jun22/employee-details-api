package com.sriteja.api.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sriteja.api.employee.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, String> {
	// JPQL (java persistence query language)
	@Query(value = "select * from employee c where c.employee_id=?1", nativeQuery = true)
	EmployeeDetails findBY(int employeeId);

	@Query(value = "select * from employee c where c.employee_id=:employee_id and c.employee_email=:employee_email", nativeQuery = true)
	EmployeeDetails findByEmployeeIdAndEmployeeEmail(@Param("employee_id") int employeeId,
			@Param("employee_email") String employeeEmail);

	@Modifying
	@Query(value = "delete from employee where employee_mobile=?1", nativeQuery = true)
	void deleteByEmployeeMobile(String employeeMobile);

}
