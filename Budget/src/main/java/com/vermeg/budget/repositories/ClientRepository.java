package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	List<Client> findByLibelleClientAndIdClient(String libelleClient, int idClient);
	List<Client> findByLibelleClient(String libelleClient);
}
