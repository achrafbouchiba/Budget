package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.entities.TypeCA;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.LotRepository;
import com.vermeg.budget.services.LotService;

@Service
public class LotServiceImpl implements LotService {

	@Autowired
	private LotRepository lotRepository;
	@Override
	public MessageResponse save(Lot lot) {
		// TODO Auto-generated method stub
		List<Lot> list= lotRepository.findByLibelleLot(lot.getLibelleLot());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "Lot Existant");
		}
		lotRepository.save(lot);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(Lot lot) {
		// TODO Auto-generated method stub
		List<Lot> list = lotRepository.findByLibelleLotAndIdLot(lot.getLibelleLot(), lot.getIdLot());
		if(list.isEmpty()) {
			list = lotRepository.findByLibelleLot(lot.getLibelleLot());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Lot Existant");
			}
		}
		
		lotRepository.save(lot);
		
		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		lotRepository.deleteById(id);
		return new MessageResponse(true,"suppression avec succés");
	}

	@Override
	public List<Lot> findAll() {
		// TODO Auto-generated method stub
		return lotRepository.findAll();
	}
	
	@Override
	public List<Lot> findByProjet(Projet projet) {
		// TODO Auto-generated method stub
		return  lotRepository.findByProjet(projet);
	}

	@Override
	public List<Lot> findByProduit(Produit produit) {
		// TODO Auto-generated method stub
		return  lotRepository.findByProduit(produit);
	}

	@Override
	public List<Lot> findByTypeCA(TypeCA typeCA) {
		// TODO Auto-generated method stub
		return  lotRepository.findByTypeCA(typeCA);
	}

	
	

}
