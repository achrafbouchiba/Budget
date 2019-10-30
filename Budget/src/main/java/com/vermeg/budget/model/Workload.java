package com.vermeg.budget.model;

import com.vermeg.budget.entities.Client;
import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.entities.Phase;
import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.entities.TypeCA;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Workload {
	private Client client;
	private Produit produit;
	private Projet projet;
	private Lot lot;
	private Phase phase;
	private Projet probabilite;
	private TypeCA typeCa;
	private Boolean capitalisable;
	
	}
