package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.InspectorFacade.persistence.domain.Cohort;
import com.qa.InspectorFacade.persistence.domain.SentCohort;
import com.qa.InspectorFacade.service.CohortService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class CohortRest {
	
	@Autowired
	private CohortService service;
	
	@Autowired
	private MongoClientRest mongoClient;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.cohortQueue}")
	private String cohortQueuePath;
	
	@GetMapping("${path.getAllCohorts}")
    public ResponseEntity<String> getAllCohorts() {
        return mongoClient.readAllCohortsFromDatabase();
    }
	
	@GetMapping("${path.getCohort}")
	public ResponseEntity<String> getCohortByName(@PathVariable String name) {
		return mongoClient.readSingleCohortFromDatabase(name);
	}
	
	@PostMapping("${path.createCohort}")
    public Cohort createCohort(@RequestBody Cohort cohort) {
		sendToQueue(cohort);
        return service.createCohort(cohort);
    }
	
	@DeleteMapping("${path.deleteCohort}")
	public String deleteCohort(@PathVariable String name) {
		return mongoClient.deleteCohort(name);
	}
	
	private void sendToQueue(Cohort cohort){
        SentCohort cohortToStore = new SentCohort(cohort);
        jmsTemplate.convertAndSend(cohortQueuePath, cohortToStore);
    }

}
