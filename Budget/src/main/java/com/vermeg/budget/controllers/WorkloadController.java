package com.vermeg.budget.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.budget.entities.Workload;
import com.vermeg.budget.model.MessageResponse;
import com.vermeg.budget.services.WorkloadService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/workload")
public class WorkloadController {
	
	@Autowired
	private WorkloadService workloadService;
	@GetMapping
	public List<Workload> findAll(){
		return workloadService.findAll();
	}
	@PostMapping
	public MessageResponse add(@RequestBody Workload workload) {
		return workloadService.save(workload);
	}
    @PutMapping
		public MessageResponse update(@RequestBody Workload workload) {
			return workloadService.update(workload);
		}
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id")int id) {
    	return workloadService.delete(id);
    }


}
