package com.vermeg.budget.services;

import java.util.List;

import com.vermeg.budget.entities.Workload;
import com.vermeg.budget.model.MessageResponse;

public interface WorkloadService {
	
	public MessageResponse save(Workload workload);
	public MessageResponse update(Workload workload);
	public MessageResponse delete(int id);
	public List<Workload> findAll();

}
