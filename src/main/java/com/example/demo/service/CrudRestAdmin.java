package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.entity.Article;
import com.example.demo.entity.Categorie;
import com.example.demo.entity.Client;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.Marque;
import com.example.demo.entity.SousCategorie;
import com.example.demo.entity.VenteFlash;

@FeignClient(name = "CrudApplication" , url = "http://localhost:8011/CrudApplication")

public interface CrudRestAdmin {
	// Fournisseur Feign
	
	@GetMapping("/fournisseur")
	public Resources<Fournisseur> getAllFour();
	
	
	@PostMapping("/fournisseur")
	public Fournisseur addFour(Fournisseur fournisseur);
	
	@GetMapping("/fournisseur/{id}")
	public Optional<Fournisseur> findFourById(@PathVariable("id") String id);	
	
	@DeleteMapping("/fournisseur/{login}")
	public void deleteByLogin(@PathVariable("login") String login);
	
	@PutMapping("/fournisseur/{login}")
	public Fournisseur modifyFour(Fournisseur fournisseur ,@PathVariable("login") String login);
	
	// Client Feign 
	@GetMapping("/listClient")
	public List<Client> findAllClient();
	
	
	@GetMapping("/client")
	public Resources<Client> getAllClient();
	
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id);
	
	@PostMapping("/client")
	public Client addClient(Client client);
	
	@DeleteMapping("/client/{Id}")
	public void deleteByIdCl(@PathVariable("Id") String Id);
	
	@PutMapping("/client/{id}")
	public Client modifyCl(Client client ,@PathVariable("id") String id);
	
	// Article Feign
	
	@GetMapping("/article")
	public Resources<Article> getAllArticle();
	
	@PutMapping("/article/{id}")
	public Article putArticle(Article article , @PathVariable("id") String id);
	
	//  Categorie Feign
	
	@GetMapping("/categorie")
	public Resources<Categorie> findAllCategoreis();
	
	@GetMapping("/categorie/{id}")
	public Optional<Categorie> findCategoreisById(@PathVariable("id") String id);
	
	@PostMapping("/categorie")
	public Categorie addCategorie(Categorie categorie);
	
	@DeleteMapping("/categorie/{id}")
	public void deleteCategorieById(@PathVariable("id") String id);
	
	@PutMapping("/categorie/{id}")
	public Categorie modifyCategorie(Categorie categorie ,@PathVariable("id") String id);
	
	// Sous Categories Feign
	
	@GetMapping("/souscategorie")
	public Resources<SousCategorie> findAllSousCategoreis();
	
	@GetMapping("/souscategorie/{id}")
	public Optional<SousCategorie> findSousCategoreisById(@PathVariable("id") String id);
	
	@PostMapping("/souscategorie") 
	public SousCategorie addSousCategorie(SousCategorie sousCategorie);
	
	@DeleteMapping("/souscategorie/{id}")
	public void deleteSousCategorieById(@PathVariable("id") String id);
	
	@PutMapping("/souscategorie/{id}")
	public SousCategorie modifySousCategorie(SousCategorie sousCategorie ,@PathVariable("id") String id);
	
	// Marque Feign
	
	@GetMapping("/marque")
	public Resources<Marque> findAllMarque();
	
	@GetMapping("/marque/{id}")
	public Optional<Marque> findMarqueById(@PathVariable("id") String id);
	
	@PostMapping("/marque")
	public Marque addMarque(Marque marque);
	
	@DeleteMapping("/marque/{id}")
	public void deleteMarqueById(@PathVariable("id") String id);
	
	@PutMapping("/marque/{id}")
	public Marque modifyMarque(Marque marque ,@PathVariable("id") String id);
	
	// vente Flash Feign
	
	@GetMapping("/venteflash")
	public Resources<VenteFlash> findAllventeflash();
	
	
	@GetMapping("/venteflash/{id}")
	public Optional<VenteFlash> findVentFlashById(@PathVariable("id") String id);
	
	@PostMapping("/venteflash")
	public VenteFlash addVenteFlash(VenteFlash venteFlash);
	
	@DeleteMapping("/venteflash/{id}")
	public void deleteVenteFlashById(@PathVariable("id") String id);
	
	@PutMapping("/venteflash/{id}")
	public VenteFlash modifyVenteFlash(VenteFlash venteFlash ,@PathVariable("id") String id);
	
	@DeleteMapping("/deleteAll")
	public void deleteAllVF();
}
