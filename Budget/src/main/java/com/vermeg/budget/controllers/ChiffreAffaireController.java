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

import com.vermeg.budget.entities.ChiffreAffaire;
import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.model.RecapCAProba;
import com.vermeg.budget.model.RecapCATypeCA;
import com.vermeg.budget.services.ChiffreAffaireService;

@RestController
@RequestMapping("/chiffreAffaire")
public class ChiffreAffaireController {
	
	

	@Autowired
	private ChiffreAffaireService chiffreAffaireService;
	
	
	@GetMapping("/{idLot}")
	public List<ChiffreAffaire> findByLot(@PathVariable("idLot") int idLot){
		Lot lot = new Lot();
		lot.setIdLot(idLot);
		return chiffreAffaireService.findByLot(lot);
	}
	@GetMapping("/recapCAType/{annee}")
	public List<RecapCATypeCA> getRecapTypeCa(@PathVariable("annee") String annee){
     
		return chiffreAffaireService.getRecapTypeCa(annee);
	}
	
	@GetMapping("/recapCAProb/{annee}")
	public List<RecapCAProba> getRecapTypeProba(@PathVariable("annee") String annee){
     
		return chiffreAffaireService.getRecapCa(annee);
	}
	@PostMapping
	public void add(@RequestBody ChiffreAffaire chiffreAffaire) {
		 chiffreAffaireService.save(chiffreAffaire);
	}
    @PutMapping
		public void update(@RequestBody ChiffreAffaire chiffreAffaire) {
			 chiffreAffaireService.update(chiffreAffaire);
		}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")int id) {
    	 chiffreAffaireService.delete(id);
    }

}
