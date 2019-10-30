package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vermeg.budget.entities.ChiffreAffaire;
import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.model.RecapCAProba;
import com.vermeg.budget.model.RecapCATypeCA;

public interface ChiffreAffaireRepository extends JpaRepository<ChiffreAffaire, Integer> {

	public List<ChiffreAffaire> findByLot(Lot lot);

	@Query("select new com.vermeg.budget.model.RecapCAProba(l.probabilite, SUM(c.totalAvecProbabilite), SUM(c.totalSansProbabilite)) from ChiffreAffaire c inner join c.lot l where c.annee =:annee group by l.probabilite ")
	List<RecapCAProba> getRecapCa(@Param("annee") String annee);

	
	@Query("select new com.vermeg.budget.model.RecapCATypeCA(t.libelle, SUM(c.totalAvecProbabilite), SUM(c.totalSansProbabilite)) from ChiffreAffaire c inner join c.lot l inner join l.typeCA t  where c.annee =:annee group by t.libelle ")
	List<RecapCATypeCA> getRecapTypeCa(@Param("annee") String annee);
}
