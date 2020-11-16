	package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	        http.authorizeRequests().antMatchers("/categorie/**").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("/fournisseur/**").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("/article/**").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("/client/**").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("/souscategorie/**").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("/marque/**").hasAuthority("ADMIN");
	        http.authorizeRequests().antMatchers("/venteflash/**").permitAll();
	        
	        http.authorizeRequests().antMatchers("/articleventeflash/**").permitAll();
	        http.authorizeRequests().anyRequest().authenticated();
	       http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
}
	