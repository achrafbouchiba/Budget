package com.vermeg.budget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.Contact;
import java.lang.String;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	List<Contact> findByEmailAndId(String email, int id);
		List<Contact> findByEmail(String email);
		
	List<Contact> findByUsernameAndId(String username, int id);
		List<Contact> findByUsername(String username);
}
