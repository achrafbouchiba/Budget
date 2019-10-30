package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Contact;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.ContactRepository;
import com.vermeg.budget.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
		@Autowired
		private ContactRepository contactRepository;
		@Autowired
		private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	@Override
	public MessageResponse save(Contact contact) {
		List<Contact> list= contactRepository.findByEmail(contact.getEmail());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "Email Existant");
		}
		list = contactRepository.findByUsername(contact.getUsername());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "Nom d'utilisateur Existant");
		}
		String passwd = bCryptPasswordEncoder.encode(contact.getPassword());
		contact.setPassword(passwd);
		
		contactRepository.save(contact);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(Contact contact) {
		
		List<Contact> list = contactRepository.findByEmailAndId(contact.getEmail(), contact.getId());
		if(list.isEmpty()) {
			list = contactRepository.findByEmail(contact.getEmail());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Email Existant");
			}
		}
		list = contactRepository.findByUsernameAndId(contact.getUsername(), contact.getId());
		if(list.isEmpty()) {
			list = contactRepository.findByUsername(contact.getUsername());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Nom d'Utilisateur Existant");
			}
		}
		
		contactRepository.save(contact);
		
		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
		return new MessageResponse(true,"suppression avec succés");
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Contact> contacts= contactRepository.findByUsername(username);
				if(!contacts.isEmpty()) {
					return contacts.get(0);
				}
		return null;
	}

}
