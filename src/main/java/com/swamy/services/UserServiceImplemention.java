package com.swamy.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.swamy.entity.Employees;
import com.swamy.entity.Roles;
import com.swamy.entity.User;
import com.swamy.repos.EmployeeRepo;
import com.swamy.repos.RolesRepo;
import com.swamy.repos.UserRepo;

@Service
public class UserServiceImplemention implements UserServiceInterface {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RolesRepo rolesRepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void createUsers(User user) {
		List<Roles> roles = Arrays.asList(new Roles("USER"));
		User user1 = new User(user.getFirstName(), user.getLastName(), user.getEmail(),
				bCryptPasswordEncoder.encode(user.getPassword()),
				bCryptPasswordEncoder.encode(user.getConfirmPassword()), roles);
		User save = userRepo.save(user1);
		System.out.println("user saved successfully.." + save);

	}

	@Override
	public List<Employees> LoadUsersFromDataBase() {
		List<Employees> empList = employeeRepo.findAll();
		return empList;
	}

	@Override
	public void modifyEmployeeDetails(int id, Employees employees) throws Exception {
		Employees emp1 = employeeRepo.findByEmpId(id);
		if (emp1 != null) {
			emp1.setFirstName(employees.getFirstName());
			emp1.setLastName(employees.getLastName());
			emp1.setDesignation(employees.getDesignation());
			employeeRepo.save(emp1);
		} else {
			throw new Exception("No such Employee in database ..");
		}

	}

	@Override
	public void saveEmployee(Employees employees) {
		Employees employeeById = getEmployeeById(employees.getId());

		if (employeeById != null) {
			employeeById.setFirstName(employees.getFirstName());
			employeeById.setLastName(employees.getLastName());
			employeeById.setDesignation(employees.getDesignation());
			employeeRepo.save(employeeById);

		}
		employeeRepo.save(employees);

	}

	@Override
	public void deleteEmployee(long empId) {
		Employees emp = employeeRepo.findByEmpId(empId);
		employeeRepo.delete(emp);
		System.out.println("employee deleted");

	}

	@Override
	public Employees getEmployeeById(long id) {
		Employees emp = employeeRepo.findByEmpId(id);
		return emp;
	}

	@Override
	public Page<Employees> loadEmployeesFromDataBaseBySortAndPagination() {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		int a = 0, b = 20;
		Pageable pageable = PageRequest.of(a, b, sort);
		Page<Employees> pagEmpList = employeeRepo.findAll(pageable);
		return pagEmpList;
	}

}
