package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{

	List<Produit> findByLibelleProduit(String libelleProduit);

	List<Produit> findByLibelleProduitAndId(String libelleProduit, int id);
}