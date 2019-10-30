package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.model.BudgetEmployee;

public interface BudgetEmployeeService {

	public List<BudgetEmployee> findEmployee(String matricule);
}
