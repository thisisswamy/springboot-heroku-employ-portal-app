package com.swamy.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.swamy.entity.Roles;
import com.swamy.repos.UserRepo;

@Component
public class MyCustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.swamy.entity.User findByEmail = userRepo.findByEmail(username);
//		System.out.println("user from data base : "+findByEmail);
		String email = findByEmail.getEmail();
		String password = findByEmail.getPassword();
		List<Roles> roles = findByEmail.getRoles();
		return new User(email, password, roles);
	}

}
