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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Projet implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomProjet;
	

	private String societe;
	private Boolean capitalisable;
	

	private Date dateDebut;
	private Date dateFin;
	private Date dateFinPrevu;
	private int coutJh;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<Lot> lot;
	@JsonIgnore
	@OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
	private Collection<Ressource> ressource;
	
	
	

	

}
