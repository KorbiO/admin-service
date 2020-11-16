package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;

import com.example.demo.entity.Categorie;
import com.example.demo.entity.Client;
import com.example.demo.entity.Fournisseur;
import com.example.demo.entity.Marque;
import com.example.demo.entity.SousCategorie;
import com.example.demo.entity.VenteFlash;
import com.example.demo.service.CrudRestAdmin;



@RestController

public class AdminController {
	
	@Autowired
	private CrudRestAdmin service;
	
	// Gestion de Fournisseur
	
	@GetMapping("/fournisseur")
	public Resources<Fournisseur> getAllFour(){
		return service.getAllFour();
	}
	
	@GetMapping("/fournisseur/{id}")
	public Optional<Fournisseur> findFourById(@PathVariable("id") String id) {
		return service.findFourById(id);
	}
	@PostMapping("/fournisseur")
	public Fournisseur addFour(@RequestBody Fournisseur fournisseur) {

		Fournisseur four = new Fournisseur();
		//four.setId(fournisseur.getId());
		four.setMat(UUID.randomUUID().toString().replace("-", ""));
		four.setAddress(fournisseur.getAddress());
		four.setNom(fournisseur.getNom());
		four.setPhoneNumber(fournisseur.getPhoneNumber());
		four.setPassword(fournisseur.getPassword());
		four.setPrenom(fournisseur.getPrenom());
		four.setUsername(fournisseur.getUsername());
		
		service.addFour(fournisseur);
		return fournisseur;	
	}
	
	@DeleteMapping("/fournisseur/{login}")
	public void deleteFou(@PathVariable("login") String login) {
		
		service.deleteByLogin(login);
	}
	
	@PutMapping("/fournisseur/{id}")
	public Fournisseur modifyFour(@RequestBody Fournisseur fournisseur , @PathVariable("id") String id) {
		
		Optional<Fournisseur> f = service.findFourById(id);
		Fournisseur four = new Fournisseur();
		four.setAddress(fournisseur.getAddress());
		four.setId(fournisseur.getId());
		four.setMat(fournisseur.getMat());
		four.setUsername(fournisseur.getUsername());
		four.setNom(fournisseur.getNom());
		four.setPhoneNumber(fournisseur.getPhoneNumber());
		four.setPassword(fournisseur.getPassword());
		four.setPrenom(fournisseur.getPrenom());
		four.setRole(fournisseur.getRole());
		service.modifyFour(four , id);
		return four;	
	}
	
	// Consulter toutes les articles
	
	@GetMapping("/article")
	public Resources<Article> getAllArticle(){
		return service.getAllArticle();
	}
	
	// Gestion des Clients
	
	@GetMapping("/client")
	public Resources<Client> getAllClient(){
		return service.getAllClient();
	}
	@GetMapping("/listClient")
	public List<Client> findAllClient(){
		return service.findAllClient();
	}
	@GetMapping("/client/{id}")
	public Optional<Client> findClientById(@PathVariable("id") String id) {
		return service.findClientById(id);
	}
	
	@PostMapping("/client")
	public Client addClient(@RequestBody Client client) {

		Client cl = new Client();
	//	cl.setId(client.getId());
		cl.setMat(UUID.randomUUID().toString().replace("-", ""));
		cl.setAddress(client.getAddress());
		cl.setCin(client.getCin());
		cl.setUsername(client.getUsername());
		cl.setNom(client.getNom());
		cl.setPhoneNumber(client.getPhoneNumber());
		cl.setPassword(client.getPassword());
		cl.setPrenom(client.getPrenom());
		cl.setRole(client.getRole());
		service.addClient(cl);
		return cl;
	}

	@DeleteMapping("/client/{Id}")
	public void deleteCl(@PathVariable("Id") String Id) {
		
		service.deleteByIdCl(Id);
	}
	
	@PutMapping("/client/{id}")
	public Client modifyCl(@RequestBody Client client , @PathVariable("id") String id) {
		
		Optional<Client> c = service.findClientById(id);
		Client cl = new Client();
		cl.setMat(client.getMat());
		cl.setId(client.getId());
		cl.setAddress(client.getAddress());
		cl.setCin(client.getCin());
		cl.setUsername(client.getUsername());
		cl.setNom(client.getNom());
		cl.setPhoneNumber(client.getPhoneNumber());
		cl.setPassword(client.getPassword());
		cl.setPrenom(client.getPrenom());
		cl.setRole(client.getRole());
		service.modifyCl(cl, id);
		return cl;
	}
	
	// Gestion Categories
	
	@GetMapping("/categorie")
	public Resources<Categorie> getAllCategorie(){
		return service.findAllCategoreis();
	}
	
	@PostMapping("/categorie")
	public Categorie addCategorie(@RequestBody Categorie categorie) {
		Categorie c = new Categorie();
		c.setMat(UUID.randomUUID().toString().replace("-", ""));
		c.setLibelleCat(categorie.getLibelleCat());
		service.addCategorie(c);
		return c ;
	}
	
	@DeleteMapping("/categorie/{id}")
	public void deleteCategorieById(@PathVariable("id") String id){
		service.deleteCategorieById(id);
	}
	
	@PutMapping("/categorie/{id}")
	public Categorie modifyCategorie(@RequestBody Categorie categorie ,@PathVariable("id") String id) {
			service.modifyCategorie(categorie, id);
		return categorie ;
	}
	
	// Gestion SousCategorie
	
	@GetMapping("/souscategorie")
	public Resources<SousCategorie> getAllSousCategoreis(){
		return service.findAllSousCategoreis();
	}
	@GetMapping("/categorie/{id}")
	public Categorie findCategoreisById(@PathVariable("id") String id) {
		return service.findCategoreisById(id).orElse(null);
	}
	
	@PostMapping("/souscategorie") 
	public SousCategorie addSousCategorie(@RequestBody SousCategorie sousCategorie ) {
		
		 SousCategorie sousCat = new SousCategorie();
   
         sousCat.setMat(UUID.randomUUID().toString().replace("-", ""));
         sousCat.setLibelleSousCat(sousCategorie.getLibelleSousCat());
         sousCat.setValeur(sousCategorie.getValeur());
         Categorie cat = service.findCategoreisById(sousCategorie.getCategorie().getIdCat()).orElse(null);
         if (cat != null )
         {
             System.err.println(cat);
             sousCat.setCategorie(cat);
         }
        
         service.addSousCategorie(sousCat);
         return sousCat ;
	}
	
	@DeleteMapping("/souscategorie/{id}")
	public void deleteSousCategorieById(@PathVariable("id") String id) {
		service.deleteSousCategorieById(id);
	}
	
	@PutMapping("/souscategorie/{id}")
	public SousCategorie modifySousCategorie(@RequestBody SousCategorie sousCategorie ,@PathVariable("id") String id) {
		SousCategorie s = new SousCategorie();
		
		 s.setMat(sousCategorie.getMat());
		 s.setIdSousCat(sousCategorie.getIdSousCat());
		s.setLibelleSousCat(sousCategorie.getLibelleSousCat());
		s.setValeur(sousCategorie.getValeur());
		Categorie c1 = service.findCategoreisById(sousCategorie.getCategorie().getIdCat()).orElse(null);
		s.setCategorie(c1);
		service.modifySousCategorie(s, id);
		return s ;
	}
	@GetMapping("/souscategorie/{id}")
	public Optional<SousCategorie> getSouscategorieById(@PathVariable("id") String id ){
		return service.findSousCategoreisById(id);
	}
	// Gestion Marque
	
	@GetMapping("/marque")
	public Resources<Marque> getAllMarque(){
		return service.findAllMarque();
	}
	@GetMapping("/marque/{id}")
	public Optional<Marque> findMarqueById(@PathVariable("id") String id){
		return service.findMarqueById(id);
	}
	@PostMapping("/marque")
	public Marque addMarque( @RequestBody Marque marque) {
		Marque m = new Marque();
		m.setMat(UUID.randomUUID().toString().replace("-", ""));
		
		m.setLibelleMarq(marque.getLibelleMarq());
		 
		
		service.addMarque(m);
		return m ;
	}
	
	@DeleteMapping("/marque/{id}")
	public void deleteMarqueById(@PathVariable("id") String id) {
		service.deleteMarqueById(id);
	}
	
	@PutMapping("/marque/{id}")
	public Marque modifyMarque(@RequestBody Marque marque ,@PathVariable("id") String id) {
		Marque m = new Marque();
		m.setLibelleMarq(marque.getLibelleMarq());
		m.setIdMarq(marque.getIdMarq());
		m.setMat(marque.getMat());
		service.modifyMarque(m, id);
		return m ;
	}
	
	// Gestion Vente Flash
	
	@GetMapping("/venteflash")
	public Resources<VenteFlash> getAllVenteFlash(){
		return service.findAllventeflash();
	}
	
	@PostMapping("/venteflash")
	public VenteFlash addVenteFlash( @RequestBody VenteFlash venteFlash) {
		VenteFlash v = new VenteFlash();
		
		v.setMat(UUID.randomUUID().toString().replace("-", ""));
		v.setDateDebVF(venteFlash.getDateDebVF());
		v.setDateFinVF(venteFlash.getDateFinVF());
		v.setArticleVenteFlash(venteFlash.getArticleVenteFlash());
		service.addVenteFlash(v);
		
		return v;
	}
	
	@Scheduled(fixedDelay = 3600000)
	@DeleteMapping("/venteflash")
	public void deleteVenteFlashById() {
		Resources<VenteFlash> v1 = service.findAllventeflash();
		
		System.err.println(v1 );
		LocalDateTime l1 = LocalDateTime.now();
		for (VenteFlash v : v1) {
	 		System.err.println("heloo");
			if (l1.isAfter(v.getDateFinVF())) {
				System.err.println(l1);
				System.err.println(v.getDateFinVF());
				List<Article> article = v.getArticleVenteFlash();
				System.err.println("heloo2");
				if(article != null) {
				for (Article a : article) {
					System.err.println("heloo3");
					a.setQteStockArt(a.getQteStockArt() + a.getQteStockArtVF());
					a.setQteStockArtVF(0);
				}
				service.deleteAllVF();
				}
			}
		}
		 
		
	}
	
	
	
	@PutMapping("/venteflash/{id}")
	public VenteFlash modifyVenteFlash(@RequestBody VenteFlash venteFlash ,@PathVariable("id") String id) {
		service.modifyVenteFlash(venteFlash, id);
		return venteFlash;
	}
	@GetMapping("/venteflash/{id}")
	public VenteFlash findVentFlashById(@PathVariable("id") String id){
		return service.findVentFlashById(id).orElse(null);
	}
	


}
