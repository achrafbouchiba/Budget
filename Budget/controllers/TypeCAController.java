package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.entities.TypeCA;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.TypeCAService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/typeCa")
public class TypeCAController {
	
	@Autowired
	private TypeCAService typeCAService;
	
	@GetMapping
	public List<TypeCA> findAll(){
		return typeCAService.findAll();
	}
	//@PreAuthorize("hasRole('ROLE_Admin')or hasRole('ROLE_User')")
	@PostMapping
	public MessageResponse add(@RequestBody TypeCA typeCA) {
		return typeCAService.save(typeCA);
	}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping
		public MessageResponse update(@RequestBody TypeCA typeCA) {
			return typeCAService.update(typeCA);
		}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return typeCAService.delete(id);
    }
}
