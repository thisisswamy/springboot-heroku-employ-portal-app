package com.swamy.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swamy.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select s from User s where s.email=?1") 
	public User findByEmail(String email);

}
