package com.vermeg.budget.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Workload implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String lot;
	private String phase;
	private String projet;
	private String produit;
	private String client;
	private String societe;
	private String typeCa;
	private String description;
	private Long workLoadTotal;
}
