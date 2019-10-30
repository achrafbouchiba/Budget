package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.Client;
import com.vermeg.budget.model.MessageResponse;

public interface ClientService {
	public MessageResponse save(Client client);
	public MessageResponse update(Client client);
	public MessageResponse delete(int id);
	public List<Client> findAll();
}
