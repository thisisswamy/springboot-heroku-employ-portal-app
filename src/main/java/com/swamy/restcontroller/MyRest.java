package com.swamy.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.entity.Roles;
import com.swamy.entity.User;
import com.swamy.repos.UserRepo;

@RestController
public class MyRest {
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/save")
	public String Save(@RequestBody User user) {
		List<Roles> list = Arrays.asList(new Roles("USER"), new Roles("ADMIN"));

		User user1 = new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
				user.getConfirmPassword(), list);
		User save = userRepo.save(user1);

		return "user saved";

	}

	@GetMapping("/am")
	public String hString() {
		return "hai..";
	}

}
