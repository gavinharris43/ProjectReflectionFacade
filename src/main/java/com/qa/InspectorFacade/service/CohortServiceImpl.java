package com.qa.InspectorFacade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.qa.InspectorFacade.persistance.repository.CohortRepo;

public class CohortServiceImpl {
	
	@Autowired
	private CohortRepo repo;
	
	@Override
	public List<Trainee> getCohorts() {
		return repo.findAll();
	}
	
	@Override
	public Cohort createTrainee(Cohort cohort) {
		return repo.save(cohort);
	}
	
	@Override
	public ResponseEntity<Object> deleteCohort(Long id) {
		if (cohortExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Override
	public ResponseEntity<Object> updateCohort(Cohort cohort, Long id) {
		if (cohortExists(id)) {
			cohort.setCohortID(id);
			repo.save(cohort);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	private boolean cohortExists(Long id){
        Optional<Cohort> cohortOptional = repo.findById(id);
        return cohortOptional.isPresent();
    }

}
