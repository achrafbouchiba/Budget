package com.vermeg.budget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.budget.entities.Workload;

public interface WorkloadRepository extends JpaRepository<Workload, Integer> {
	
	List<Workload> findByTypeCaAndId(String typeCa, int id);
	List<Workload> findByTypeCa(String typeCa);
}
