package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	private String id;		
	private String mat;
	private String username; 			
	private String password ; 				
	private String nom;						
	private String prenom;				
	private String role; 			
															
	private String cin; 
	private String address;
	private String phoneNumber;
	public String getId( ) {
		return this.mat;
	}
	
}
