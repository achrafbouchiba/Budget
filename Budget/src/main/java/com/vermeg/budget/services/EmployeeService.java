package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.Employee;
import com.vermeg.budget.model.MessageResponse;

public interface EmployeeService {
	public MessageResponse save(Employee employee);
	public MessageResponse update(Employee employee);
	public MessageResponse delete(String matricule);
	public List<Employee> findAll();

}
