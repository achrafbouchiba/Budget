package com.vermeg.budget.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecapCAProba {
	private double probabilite;
	private double totalWithProb;
	private double totalWithoutProb;
}
