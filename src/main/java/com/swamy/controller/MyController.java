package com.swamy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.swamy.entity.Employees;
import com.swamy.entity.User;
import com.swamy.services.UserServiceInterface;

@Controller
public class MyController {
	@Autowired
	UserServiceInterface userServiceInterface;

	@GetMapping("/mylogin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage() {
//		System.out.println("from register : "+user);
		return "register";
	}

	@PostMapping("/register")
	public String homePage(User user) {
		System.out.println("from home : " + user);
		userServiceInterface.createUsers(user);
//		userServiceInterface.LoadUsersFromDataBase();
		return "register";
	}

	@GetMapping("/home")
	public String homePage2(Model model) {
//		List<Employees> empList = userServiceInterface.LoadUsersFromDataBase();
//		model.addAttribute("empList", empList);
		showData(model);
		return "home";
	}

	@GetMapping("/")
	public String home(Model model) {
//		List<Employees> empList = userServiceInterface.LoadUsersFromDataBase();
//		model.addAttribute("empList", empList);
		showData(model);
		return "home";
	}

	@GetMapping("/addEmployee")
	public String addEmployee() {
		return "addEmp";
	}

	@PostMapping("/")
	public String savingEmployee( Employees employees, Model model) {
//		System.out.println("After sumbit root Url : " + "with Id : "+employees.getId()+" --> "+ employees);
		userServiceInterface.saveEmployee(employees);
		showData(model);
//		List<Employees> empList = userServiceInterface.LoadUsersFromDataBase();
//		model.addAttribute("empList", empList);
		return "home";

	}

	public void showData(Model model) {
//		List<Employees> empList = userServiceInterface.LoadUsersFromDataBase();
		Page<Employees> loadEmployeesFromDataBaseBySortAndPagination = userServiceInterface.loadEmployeesFromDataBaseBySortAndPagination();
		List<Employees> empList1=loadEmployeesFromDataBaseBySortAndPagination.getContent();
//		empList1.forEach(System.out::println);
		model.addAttribute("empList", empList1);
	}

	@GetMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") long empId, Model model) {
//		System.out.println(empId);
		userServiceInterface.deleteEmployee(empId);
		showData(model);
		return "redirect:/home";
	}

	@GetMapping("/{id}")
	public String editEmployee(@PathVariable long id,@ModelAttribute("employeeObject") Employees employees) {
//		System.out.println("Edit emple id : "+ id);
		Employees emp = userServiceInterface.getEmployeeById(id);
		
		employees.setId(emp.getId());
		employees.setFirstName(emp.getFirstName());
		employees.setLastName(emp.getLastName());
		employees.setDesignation(emp.getDesignation());
		return "editEmp";
	}
//	@PutMapping("/")
//	public String updateUser(@RequestBody Employees employees) {
//		return null;
//		
//	}

}
