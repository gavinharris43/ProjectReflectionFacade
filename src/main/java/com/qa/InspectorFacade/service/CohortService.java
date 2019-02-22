package com.qa.InspectorFacade.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.InspectorFacade.persistence.domain.Cohort;

public interface CohortService {
	
	List<Cohort> getCohorts();
	
	Cohort getCohortByName(String name);

    Cohort createCohort(Cohort cohort);

    ResponseEntity<Object> deleteCohort(Long id);

    ResponseEntity<Object> updateCohort(Cohort cohort, Long id);

}
