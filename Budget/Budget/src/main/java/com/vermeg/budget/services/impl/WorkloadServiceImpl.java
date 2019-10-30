package com.vermeg.budget.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.Workload;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.repositories.WorkloadRepository;
import com.vermeg.budget.services.WorkloadService;

@Service
public class WorkloadServiceImpl implements WorkloadService{


	@Autowired
	private WorkloadRepository workloadRepository;
	@Override
	public MessageResponse save(Workload workload) {
		// TODO Auto-generated method stub
		List<Workload> list= workloadRepository.findByTypeCa(workload.getTypeCa());

		workloadRepository.save(workload);
		return new MessageResponse(true, "Ajout effectuée avec succés");
	}

	@Override
	public MessageResponse update(Workload workload) {
		// TODO Auto-generated method stub
		List<Workload> list = workloadRepository.findByTypeCaAndId(workload.getTypeCa(), workload.getId());
		if(list.isEmpty()) {
			list = workloadRepository.findByTypeCa(workload.getTypeCa());
			
			if(!list.isEmpty()) {
				return new MessageResponse(false,"Workload Existant");
			}
		}
		
		workloadRepository.save(workload);
		
		return new MessageResponse(true, "Modification effectuee avec succés");
	}

	@Override
	public MessageResponse delete(int id) {
		// TODO Auto-generated method stub
		workloadRepository.deleteById(id);
		return new MessageResponse(true,"suppression avec succés");
	}

	@Override
	public List<Workload> findAll() {
		// TODO Auto-generated method stub
		return workloadRepository.findAll();
	}

}
