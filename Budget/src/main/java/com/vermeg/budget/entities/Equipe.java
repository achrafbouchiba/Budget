package com.vermeg.budget.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



import lombok.Data;

@Entity
@Data
public class Equipe implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEquipe;
	private String chefEquipe;
	private String nomEquipe;
	private String pays;

	@OneToMany(mappedBy="equipe",fetch=FetchType.LAZY)
	private Collection<Employee> employee;
	
	@ManyToOne
	private Produit produit;
	

	
	
}
