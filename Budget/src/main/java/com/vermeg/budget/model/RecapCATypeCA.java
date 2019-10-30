package com.vermeg.budget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecapCATypeCA{
	private String  libelle;
	private double totalWithProb;
	private double totalWithoutProb;
}
