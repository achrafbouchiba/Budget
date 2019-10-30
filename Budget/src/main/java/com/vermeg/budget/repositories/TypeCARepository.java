package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.TypeCA;

public interface TypeCARepository extends JpaRepository<TypeCA, Integer>{

	List<TypeCA> findByLibelle(String libelle);

	List<TypeCA> findByLibelleAndId(String libelle, int id);

}
