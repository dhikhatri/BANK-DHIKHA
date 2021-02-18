/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.nasabah.security;

/**
 *
 * @author fujitsu
 */
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
        
        
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select email, password,'true' as enabled from nasabah where email=?")
		.authoritiesByUsernameQuery(
			"select email, 'ROLE_USER' from nasabah where email=?");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/nasabah/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.GET, "/api/nasabah/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.POST, "/api/nasabah/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.PUT, "/api/nasabah/**").access("hasRole('ROLE_USER')")
                .antMatchers(HttpMethod.DELETE, "/api/nasabah/**").access("hasRole('ROLE_USER')")
//                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/api/nasabah").permitAll()
                .and()
                .logout().permitAll();

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}