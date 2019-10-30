package com.vermeg.budget.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Lot implements Serializable {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLot;                        
	private String libelleLot;
	private double montantDeDeal;
	private String phase;
	@ManyToOne
	@JoinColumn(name="id_projet")
	private Projet projet;
	private double probabilite;
	@ManyToOne
	@JoinColumn(name="id_typeCA")
	private TypeCA typeCA;
	
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="lot",fetch=FetchType.LAZY)
	private List<ChiffreAffaire> chiffreAffaires;
}
