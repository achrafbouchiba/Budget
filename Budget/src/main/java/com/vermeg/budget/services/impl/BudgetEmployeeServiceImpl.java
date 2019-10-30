package com.vermeg.budget.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Employee;
import com.vermeg.budget.model.BudgetEmployee;
import com.vermeg.budget.repositories.EmployeeRepository;
import com.vermeg.budget.services.BudgetEmployeeService;

@Service
public class BudgetEmployeeServiceImpl implements BudgetEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<BudgetEmployee> findEmployee(String matricule) {
	
		Employee employee = employeeRepository.findById(matricule).orElse(null);

		long monthsBetween = ChronoUnit.MONTHS.between(convertToLocalDate(employee.getDateRecrutement()), convertToLocalDate(employee.getDateFinContrat()));
	System.out.println(monthsBetween);
	
	 long mod = monthsBetween % 12;
	 double quotient = Math.floor(monthsBetween /12 );
	
	
	 List<BudgetEmployee> list = new ArrayList<>();
	 Calendar calendar = Calendar.getInstance();
	 calendar.setTime(employee.getDateRecrutement());
	 int annee = calendar.get(Calendar.YEAR);
	 double ancien = 0;
	 double baseSalaire = employee.getSalaire();
	 for(int i=0 ; i< quotient; i++) {
		 BudgetEmployee budget = new BudgetEmployee();
	
		 budget.setAnnee(annee);
	 		double salaire = baseSalaire + ( ancien * employee.getPourcentage() )/100;
		 budget.setJanvier(salaire);
		 budget.setFeverier(salaire);
		 budget.setMars(salaire);
		 budget.setAvril(salaire);
		 budget.setMai(salaire);
		 budget.setJuin(salaire);
		 budget.setJuillet(salaire);
		 budget.setAout(salaire);
		 budget.setSeptember(salaire);
		 budget.setOctober(salaire);
		 budget.setNovember(salaire);
		 budget.setDecember(salaire);
		
		 
		 budget.setTotalAnnee((salaire * 12));
		 
		 list.add(budget);
		 
		 annee++;
		 ancien = salaire;
		 baseSalaire = salaire;
		 
	 }
	 
	
	 
	 
	 if(mod!= 0) {
		 BudgetEmployee budget = new BudgetEmployee();
		 double totalAnnee = 0;
		 for(int i = 1 ; i<= mod ; i++) {
			
			 budget.setAnnee(annee);
		 		double salaire = ancien + ( ancien * employee.getPourcentage() )/100;
			 if(i ==1 ) {
				 budget.setJanvier(salaire);
				 totalAnnee += salaire;
			 }
			 if(i ==2 ) {
			 budget.setFeverier(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==3 ) {
			 budget.setMars(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==4 ) {
			 budget.setAvril(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==5 ) {
			 budget.setMai(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==6 ) {
			 budget.setJuin(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==7 ) {
			 budget.setJuillet(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==8 ) {
			 budget.setAout(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==9 ) {
			 budget.setSeptember(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==10 ) {
			 budget.setOctober(salaire);
			 totalAnnee += salaire;
			 }
			 if(i ==11 ) {
			 budget.setNovember(salaire);
			 totalAnnee += salaire;
			 }
		
			 
			
		 }
		 budget.setTotalAnnee(totalAnnee);
		 list.add(budget);
		 
		 
		 
		 
	 }
	 
	 
		return list;
	}


	private LocalDate convertToLocalDate(Date suspectDate) {

	    try {
	   
	        return suspectDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	    } catch (UnsupportedOperationException e) {
	        // BOOM!!
	    }

	    // do this first:
	    java.util.Date safeDate = new Date(suspectDate.getTime());

	    return safeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

	}
}
