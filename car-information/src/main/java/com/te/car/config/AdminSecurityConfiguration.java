package com.te.car.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.te.car.filter.JwtRequestFilter;
import com.te.car.service.AdminServiceImp;

@EnableWebSecurity
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AdminServiceImp adminServiceImp;
	
	@Autowired
	private JwtRequestFilter jwtreq;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(adminServiceImp);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable().csrf().disable().authorizeRequests()
		.antMatchers("/adminadd","/adminget","/adminall","/adminupdate","/caradd").hasRole("ADMIN")
		.antMatchers("/carget","/carall","/login").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(jwtreq,UsernamePasswordAuthenticationFilter.class);
	}

}
