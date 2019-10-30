package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.model.MessageResponse;

public interface ProjetService {
	
	public MessageResponse save(Projet projet);
	public MessageResponse update(Projet projet);
	public MessageResponse delete(int id);
	public List<Projet> findAll();

}
