package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteFlash {

	private String id;
	private LocalDateTime dateDebVF;
	private LocalDateTime dateFinVF;
	private String mat;
	public String getId() {
		return this.mat;
	}
	private List<Article> articleVenteFlash;
	
	
	
}
