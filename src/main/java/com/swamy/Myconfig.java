package com.swamy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.swamy.security.MyCustomUserDetailsService;

@EnableWebSecurity
public class Myconfig extends WebSecurityConfigurerAdapter {
	
	private static final String[] SECURE_URLS= {"/","/home","/{id}","/delete/{id}"};
	private static final String[] NON_SECURE_URLS= {"/mylogin","/register"};
	
	@Autowired
	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	
	@Autowired
	private MyCustomUserDetailsService myCustomUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("swamy")
//		.password(bCryptPasswordEncoder.encode("123")).roles("user");
		
		auth.userDetailsService(myCustomUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(NON_SECURE_URLS).permitAll()
		.antMatchers(SECURE_URLS).authenticated().and()
		.formLogin().loginPage("/mylogin").usernameParameter("myname").passwordParameter("pass")
		.and().logout();
	}
	

}
