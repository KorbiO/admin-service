package com.example.demo.entity;

import lombok.Data;

@Data
public class Marque {

	private String idMarq;
	private String mat ;
	private String libelleMarq;
	
	public String getIdMarq() {
		return this.mat ;
	}
}
