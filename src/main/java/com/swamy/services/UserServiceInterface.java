package com.swamy.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.swamy.entity.Employees;
import com.swamy.entity.User;

@Component
public interface UserServiceInterface {
	public void createUsers(User user);
	public List<Employees> LoadUsersFromDataBase();
	public void modifyEmployeeDetails(int id, Employees employees) throws Exception;
	public void saveEmployee(Employees employees);
	public void deleteEmployee(long empId);
	public Employees getEmployeeById(long id);
	
	public Page<Employees> loadEmployeesFromDataBaseBySortAndPagination();
	
		
	
	

}
