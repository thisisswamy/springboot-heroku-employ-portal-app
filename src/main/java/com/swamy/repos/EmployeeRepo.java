package com.swamy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swamy.entity.Employees;
@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

	@Query("select s from Employees s where s.id=?1") 
	Employees findByEmpId(long empId);

}
