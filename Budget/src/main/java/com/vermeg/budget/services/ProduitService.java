package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.model.MessageResponse;

public interface ProduitService {
	
	public MessageResponse save(Produit produit);
	public MessageResponse update(Produit produit);
	public MessageResponse delete(int id);
	public List<Produit> findAll();

}
