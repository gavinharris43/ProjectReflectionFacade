package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CohortRest {
	
	@Autowired
	private CohortService service;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("${path.getAllCohorts}")
    public List<Cohort> getCohorts() {
        return service.getAllCohorts();
    }
	
	@PostMapping("${path.createCohort}")
    public Cohort createCohort(@RequestBody Cohort cohort) {
        return service.createCohort(cohort);
    }
	
	@PutMapping("${path.updateTrainee}")
	public Cohort updateCohort(@RequestBody Cohort cohort, @PathVariable Long id) {
		return service.updateCohort(cohort, id);
	}
	
	@DeleteMapping("${path.deleteCohort}")
	public Cohort deleteCohort(@RequestBody Cohort cohort, @PathVariable Long id) {
		return service.deleteCohort(cohort, id);
	}
	
	private void sendToQueue(Cohort cohort){
        SentCohort cohortToStore =  new SentCohort(cohort);
        jmsTemplate.convertAndSend("AccountQueue", cohort);
    }

}
