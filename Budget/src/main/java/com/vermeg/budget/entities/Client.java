package com.vermeg.budget.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClient;
	private String libelleClient;
	private String contact;
	private String email;
	@JsonIgnore
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Projet> projet;
	

}
