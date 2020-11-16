package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

	
	private String idCat;
	
	private String libelleCat;
	private String mat;
	
	public String getIdCat( ) {
		return this.mat;
	}
}
