package com.qa.InspectorFacade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.Cohort;
import com.qa.InspectorFacade.persistence.domain.Trainer;
import com.qa.InspectorFacade.persistence.repository.CohortRepo;

@Service
public class CohortServiceImpl implements CohortService {
	
	@Autowired
	private CohortRepo repo;
	
	@Override
	public List<Cohort> getCohorts() {
		return repo.findAll();
	}
	
	@Override
	public Cohort getCohortByName(String name) {
		List<Cohort> cohortList = repo.findAll();
		for (Cohort cohort : cohortList) {
			if (cohort.getCohortName().equals(name)) {
				return cohort;
			}
		}
		return null;
	}
	
	@Override
	public Cohort createCohort(Cohort cohort) {
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
			cohort.setCohortId(id);
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
