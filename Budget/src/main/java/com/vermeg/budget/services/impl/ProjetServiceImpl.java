package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.ProjetRepository;
import com.vermeg.budget.services.ProjetService;

@Service
public class ProjetServiceImpl implements ProjetService {
	
	@Autowired
	private ProjetRepository projetRepository;
	@Override
	public MessageResponse save(Projet projet) {
		// TODO Auto-generated method stub
		List<Projet> list= projetRepository.findByNomProjet(projet.getNomProjet());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "Projet Existant");
		}
		projetRepository.save(projet);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(Projet projet) {
		// TODO Auto-generated method stub
		List<Projet> list = projetRepository.findByNomProjetAndId(projet.getNomProjet(), projet.getId());
		if(list.isEmpty()) {
			list = projetRepository.findByNomProjet(projet.getNomProjet());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Projet Existant");
			}
		}
		
		projetRepository.save(projet);
		
		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		projetRepository.deleteById(id);
		return new MessageResponse(true,"suppression avec succés");
	}

	@Override
	public List<Projet> findAll() {
		// TODO Auto-generated method stub
		return projetRepository.findAll();
	}
	

}
