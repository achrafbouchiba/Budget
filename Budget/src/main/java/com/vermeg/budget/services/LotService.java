package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.entities.TypeCA;
import com.vermeg.budget.model.MessageResponse;

public interface LotService {

	public MessageResponse save(Lot lot);
	public MessageResponse update(Lot lot);
	public MessageResponse delete(int id);
	public List<Lot> findAll();
	public List<Lot> findByProjet(Projet projet);
	public List<Lot> findByProduit(Produit produit);
	public List<Lot> findByTypeCA(TypeCA typeCA);


}
