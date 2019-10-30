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
public class ChiffreAffaire implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idChiffreAffaire;

	
	private double totalAvecProbabilite;
	private double totalSansProbabilite;
	private String annee;
	
	private double janvierWithProb;
	private double janvierWithoutProb;
	private double fevrierWithProb;
	private double fevrierWithoutProb;
	private double marsWithProb;
	private double marsWithoutProb;
	private double avrilWithProb;
	private double avrilWithoutProb;
	private double maiWithProb;
	private double maiWithoutProb;
	private double juinWithProb;
	private double juinWithoutProb;
	private double juilletWithProb;
	private double juilletWithoutProb;
	private double aoutWithProb;
	private double aoutWithoutProb;
	private double septemberWithProb;
	private double septemberWithoutProb;
	private double octoberWithProb;
	private double octoberWithoutProb;
	private double novemberWithProb;
	private double novemberWithoutProb;
	private double decemberWithProb;
	private double decemberWithoutProb;
	
	@ManyToOne
	@JoinColumn(name="id_lot")
	private Lot lot;
	
}
