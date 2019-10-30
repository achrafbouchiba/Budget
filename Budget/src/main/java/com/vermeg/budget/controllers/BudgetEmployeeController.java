package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.model.BudgetEmployee;
import com.vermeg.budget.services.BudgetEmployeeService;

@RestController
@RequestMapping("/budget")
public class BudgetEmployeeController {
	
	@Autowired
	private BudgetEmployeeService budgetEmployeeService;
	@GetMapping("/{matricule}")
	public List<BudgetEmployee> getBudget(@PathVariable String matricule) {
		return budgetEmployeeService.findEmployee(matricule);
	}

}
