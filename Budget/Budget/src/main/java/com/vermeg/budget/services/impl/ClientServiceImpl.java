package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Client;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.ClientRepository;
import com.vermeg.budget.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public MessageResponse save(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse update(Client client) {
		clientRepository.save(client);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public MessageResponse delete(int id) {
		clientRepository.deleteById(id);
		return new MessageResponse(true, "Opération effectuée avec succès");
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
