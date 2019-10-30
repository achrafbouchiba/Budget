package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vermeg.budget.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer>{
	List<Projet> findByNomProjetAndId(String nomProjet, int id);
	List<Projet> findByNomProjet(String nomProjet);
	
}
