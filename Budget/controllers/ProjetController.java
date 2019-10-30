package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.ProjetService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/projet")
public class ProjetController {
	
	@Autowired
	private ProjetService projetService;
	@GetMapping
	public List<Projet> findAll(){
		return projetService.findAll();
	}
	@PostMapping
	public MessageResponse add(@RequestBody Projet projet) {
		return projetService.save(projet);
	}
    @PutMapping
		public MessageResponse update(@RequestBody Projet projet) {
			return projetService.update(projet);
		}
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return projetService.delete(id);
    }

}
