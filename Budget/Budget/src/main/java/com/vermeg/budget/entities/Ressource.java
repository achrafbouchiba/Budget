package com.vermeg.budget.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class Ressource implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRessource;
	private int nbrJh;
	private float valeurJh;
	@ManyToOne
	@JoinColumn(name="id")
	private Projet projet;
	@ManyToOne
	@JoinColumn(name="idSalarie")
	private Employee employee;
	
	
	
}
