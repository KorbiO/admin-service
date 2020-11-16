package com.example.demo.entity;

import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousCategorie {

	private String idSousCat;
	private String mat;
	private String libelleSousCat;
	private List <String> valeur ; 
	
	private Categorie categorie;
	
	 
	public String getIdSousCat( ) {
		return this.mat;
	}
	
	
}
