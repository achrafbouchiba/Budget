package com.vermeg.budget.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vermeg.budget.entities.Contact;
import com.vermeg.budget.model.MessageResponse;

public interface ContactService extends UserDetailsService{

		public MessageResponse save(Contact contact);
		public MessageResponse update(Contact contact);
		public MessageResponse delete(int id);
		public List<Contact> findAll();


}
