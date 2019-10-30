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

import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.entities.TypeCA;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.LotService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/lot")
public class LotController {

	@Autowired
	private LotService lotService;
	@GetMapping
	public List<Lot> findAll(){
		return lotService.findAll();
	}
	
	@GetMapping("/{idProjet}")
	public List<Lot> findByProjet(@PathVariable("idProjet") int idProjet){
		Projet projet = new Projet();
		projet.setId(idProjet);
		return lotService.findByProjet(projet);
	}
	/*@GetMapping("/{idProduit}")
	public List<Lot> findByProduit(@PathVariable("idProduit") int idProduit){
		Produit produit = new Produit();
		produit.setId(idProduit);
		return lotService.findByProduit(produit);
	}
	@GetMapping("/{idTypeCA}")
	public List<Lot> findByTypeCA(@PathVariable("idTypeCA") int idTypeCA){
		TypeCA typeCA = new TypeCA();
		typeCA.setId(idTypeCA);
		return lotService.findByTypeCA(typeCA);
	}*/
	@PostMapping
	public MessageResponse add(@RequestBody Lot lot) {
		return lotService.save(lot);
	}
    @PutMapping
		public MessageResponse update(@RequestBody Lot lot) {
			return lotService.update(lot);
		}
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return lotService.delete(id);
    }
}
