package com.qa.InspectorFacade.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.InspectorFacade.persistence.domain.Cohort;
import com.qa.InspectorFacade.persistence.domain.SentCohort;
import com.qa.InspectorFacade.service.CohortServiceImpl;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class CohortRest {
	
	@Autowired
	private CohortServiceImpl service;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("{activemq.queue.name}")
	private String queueName;
	
	@GetMapping("${path.getAllCohorts}")
    public List<Cohort> getCohorts() {
        return service.getCohorts();
    }
	
	@PostMapping("${path.createCohort}")
    public Cohort createCohort(@RequestBody Cohort cohort) {
		sendToQueue(cohort);
        return service.createCohort(cohort);
    }
	
	@PutMapping("${path.updateTrainee}")
	public ResponseEntity<Object> updateCohort(@RequestBody Cohort cohort, @PathVariable Long id) {
		return service.updateCohort(cohort, id);
	}
	
	@DeleteMapping("${path.deleteCohort}")
	public ResponseEntity<Object> deleteCohort(@PathVariable Long id) {
		return service.deleteCohort(id);
	}
	
	private void sendToQueue(Cohort cohort){
        SentCohort cohortToStore =  new SentCohort(cohort);
        jmsTemplate.convertAndSend(queueName, cohort);
    }

}
