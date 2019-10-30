package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.TypeCA;
import com.vermeg.budget.model.MessageResponse;

public interface TypeCAService {

	public MessageResponse save(TypeCA typeCA);
	public MessageResponse update(TypeCA typeCA);
	public MessageResponse delete(int id);
	public List<TypeCA> findAll();
	
}
