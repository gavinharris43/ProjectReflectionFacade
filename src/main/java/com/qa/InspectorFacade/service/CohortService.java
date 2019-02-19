package com.qa.InspectorFacade.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CohortService {
	
	List<Cohort> getCohort();

    Cohort addCohort(Cohort cohort);

    ResponseEntity<Object> deleteCohort(Long id);

    ResponseEntity<Object> updateCohort(Cohort cohort, Long id);

}
