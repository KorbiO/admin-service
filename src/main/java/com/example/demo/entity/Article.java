package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	private String idArt;
	private String mat;
	private String imageName ;
	private String designtationArt;
	private String descriptionArt;
	private  double prixArt;
	private int qteStockArt;
	private  double prixArtVF;
    private int qteStockArtVF;
    private Boolean isArtVF;	
	private double tauxRemiseArt;
	public String getIdArt( ) {
		return this.mat;
	}
}
