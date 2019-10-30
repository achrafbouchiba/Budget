package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.entities.Contact;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.ContactService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public List<Contact> findAll(){
		return contactService.findAll();
	}
	@PreAuthorize("hasRole('ROLE_Administrateur')")
	@PostMapping
	public MessageResponse add(@RequestBody Contact contact) {
		return contactService.save(contact);
	}
	@PreAuthorize("hasRole('ROLE_Administrateur')")
    @PutMapping
		public MessageResponse update(@RequestBody Contact contact) {
			return contactService.update(contact);
		}
	@PreAuthorize("hasRole('ROLE_Administrateur')")
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return contactService.delete(id);
    }
}
