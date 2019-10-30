package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.entities.Produit;
import com.vermeg.budget.entities.Projet;
import com.vermeg.budget.entities.TypeCA;

public interface LotRepository extends JpaRepository<Lot, Integer> {

	List<Lot> findByProjet(Projet projet);
	
	List<Lot> findByProduit(Produit produit);
	
	List<Lot> findByTypeCA(TypeCA typeCA);

	List<Lot> findByLibelleLot(String libelleLot);

	List<Lot> findByLibelleLotAndIdLot(String libelleLot, Integer idLot);

}
