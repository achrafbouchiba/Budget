package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.entities.Client;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping
	public List<Client> findAll(){
		return clientService.findAll();
	}
	//@PreAuthorize("hasRole('ROLE_Admin')or hasRole('ROLE_User')")
	@PostMapping
	public MessageResponse add(@RequestBody Client client) {
		return clientService.save(client);
	}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping
		public MessageResponse update(@RequestBody Client client) {
			return clientService.update(client);
		}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return clientService.delete(id);
    }

}
