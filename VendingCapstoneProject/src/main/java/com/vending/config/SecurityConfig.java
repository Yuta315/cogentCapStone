//package com.vending.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	// Authentication
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.inMemoryAuthentication().withUser("Yuta").password("{noop}Yuta").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER");
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
///*
//* http://localhost:8080/
//* http://localhost:8080/emp
//* http://localhost:8080/newmep
//*/
//
//// Authorization
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("ADMIN").and().formLogin().loginPage("/login")
//		.failureUrl("/login?error=1").loginProcessingUrl("/login").permitAll().and().logout().logoutSuccessUrl("/adominpage");
////		http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER").and().formLogin().loginPage("/login")
//////		.failureUrl("/login.jsp?error=1").loginProcessingUrl("/login").permitAll().and().logout().logoutSuccessUrl("/new_product.html");
////		.failureUrl("/login?error=1").loginProcessingUrl("/login").permitAll().and().logout().logoutSuccessUrl("/showNewOrdersForm");
//	}
//
//}