package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	List<Employee> findByEmailAndMatricule(String email, String matricule);
	List<Employee> findByEmail(String email);
	
List<Employee> findByNomAndMatricule(String nom, String matricule);


}
