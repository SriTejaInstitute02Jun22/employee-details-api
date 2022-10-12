package com.sriteja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sriteja.api.model.EmployeeDetails;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, String> {

	@Query(value="select * from employee c where c.employee_id = ?1",nativeQuery=true)
	EmployeeDetails findBy(int employeeId);
	@Query(value = "select * from employee c where c.employee_id=:employee_id and c.employee_email=:employee_email",nativeQuery=true)
	EmployeeDetails updateEmployeeDetailsBasedOnEmployeeIdAndEmployeeEmail(@Param ("employee_id")int employeeId,@Param("employee_email") String employeeEmail);
	@Modifying
	@Query(value="delete from employee c where c.employee_mobile = ?1",nativeQuery=true)
	void deleteByEmployeeMobile(String employeeMobile);

}
