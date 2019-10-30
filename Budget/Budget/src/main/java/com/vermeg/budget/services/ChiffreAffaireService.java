package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.ChiffreAffaire;
import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.model.RecapCAProba;
import com.vermeg.budget.model.RecapCATypeCA;

public  interface ChiffreAffaireService {
	public void save(ChiffreAffaire chiffreAffaire);
	public void update(ChiffreAffaire chiffreAffaire);
	public void delete(int id);
	public List<ChiffreAffaire> findByLot(Lot lot);
	
	List<RecapCAProba> getRecapCa(String annee);

	List<RecapCATypeCA> getRecapTypeCa(String annee);
}
