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

import com.vermeg.budget.entities.Employee;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.EmployeeService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	//@PreAuthorize("hasRole('ROLE_Admin')or hasRole('ROLE_User')")
	@PostMapping
	public MessageResponse add(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @PutMapping
		public MessageResponse update(@RequestBody Employee employee) {
			return employeeService.update(employee);
		}
	//@PreAuthorize("hasRole('ROLE_Admin')")
    @DeleteMapping("/{matricule}")
    public MessageResponse delete(@PathVariable("matricule")String matricule) {
    	return employeeService.delete(matricule);
    }
}
