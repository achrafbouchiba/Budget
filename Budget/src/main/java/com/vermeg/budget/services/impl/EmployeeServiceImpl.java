package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Employee;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.EmployeeRepository;
import com.vermeg.budget.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public MessageResponse save(Employee employee) {
	
		Employee emp= employeeRepository.findById(employee.getMatricule()).orElse(null);
		if(emp != null) {
			return new MessageResponse(false, "Matricule Existant");
		}
		
		
		List<Employee> list= employeeRepository.findByEmail(employee.getEmail());
		if(! list.isEmpty()) {
			return new MessageResponse(false, "Employee Existant");
		}
		employeeRepository.save(employee);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(Employee employee) {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findByEmailAndMatricule(employee.getEmail(), employee.getMatricule());
		if (list.isEmpty()) {
			list = employeeRepository.findByEmail(employee.getEmail());

			if (!list.isEmpty()) {
				return new MessageResponse(false, "Employee Existant");
			}
		}

		employeeRepository.save(employee);

		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(String matricule) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(matricule);
		return new MessageResponse(true, "suppression avec succés");
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
