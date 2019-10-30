package com.vermeg.budget.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String libelleProduit;
	private String descriptionProduit;
	@JsonIgnore
	@OneToMany(mappedBy = "produit")
	private List<Lot> lots;
	
	@JsonIgnore
	@OneToMany(mappedBy = "produit")
	private List<Equipe> equipes;
}
