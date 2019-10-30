package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.TypeCA;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.TypeCARepository;
import com.vermeg.budget.services.TypeCAService;

@Service
public class TypeCAServiceImpl implements TypeCAService {
	
	@Autowired
	private TypeCARepository typeCARepository;
	@Override
	public MessageResponse save(TypeCA typeCA) {
		// TODO Auto-generated method stub
		List<TypeCA> list= typeCARepository.findByLibelle(typeCA.getLibelle());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "TypeCA Existant");
		}
		typeCARepository.save(typeCA);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(TypeCA typeCA) {
		// TODO Auto-generated method stub
		List<TypeCA> list = typeCARepository.findByLibelleAndId(typeCA.getLibelle(), typeCA.getId());
		if(list.isEmpty()) {
			list = typeCARepository.findByLibelle(typeCA.getLibelle());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"TypeCA Existant");
			}
		}
		
		typeCARepository.save(typeCA);
		
		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		typeCARepository.deleteById(id);
		return new MessageResponse(true,"suppression avec succés");
	}

	@Override
	public List<TypeCA> findAll() {
		// TODO Auto-generated method stub
		return typeCARepository.findAll();
	}
	

}
