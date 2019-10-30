package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	

	@Autowired
	private ProduitService produitService;
	
	@GetMapping
	public List<Produit> findAll(){
		return produitService.findAll();
	}
	//@PreAuthorize("hasRole('ROLE_Admin')or hasRole('ROLE_User')")
	@PostMapping
	public MessageResponse add(@RequestBody Produit produit) {
		return produitService.save(produit);
	}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping
		public MessageResponse update(@RequestBody Produit produit) {
			return produitService.update(produit);
		}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return produitService.delete(id);
    }

}
