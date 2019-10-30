package com.vermeg.budget.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Employee implements Serializable {
	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String adresse;
	private String poste;
	@Temporal(TemporalType.DATE)
	private Date dateRecrutement;
	@Temporal(TemporalType.DATE)
	private Date dateFinContrat;
	private double salaire;
	private double pourcentage;
	@ManyToOne
	@JoinColumn(name = "idEquipe")
	private Equipe equipe;
	@OneToMany(mappedBy = "employee", fetch= FetchType.EAGER)
	private Collection<Ressource> ressources;
}
