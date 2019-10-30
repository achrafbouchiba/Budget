package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.ProduitRepository;
import com.vermeg.budget.services.ProduitService;

@Service
public class ProduitServiceImpl implements ProduitService {
	
	@Autowired
	private ProduitRepository produitRepository;
	@Override
	public MessageResponse save(Produit produit) {
		// TODO Auto-generated method stub
		List<Produit> list= produitRepository.findByLibelleProduit(produit.getLibelleProduit());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "Produit Existant");
		}
		produitRepository.save(produit);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(Produit produit) {
		// TODO Auto-generated method stub
		List<Produit> list = produitRepository.findByLibelleProduitAndId(produit.getLibelleProduit(), produit.getId());
		if(list.isEmpty()) {
			list = produitRepository.findByLibelleProduit(produit.getLibelleProduit());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Produit Existant");
			}
		}
		
		produitRepository.save(produit);
		
		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
		return new MessageResponse(true,"suppression avec succés");
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}
	

}
