package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.InspectorFacade.persistence.domain.SentTrainee;
import com.qa.InspectorFacade.persistence.domain.Trainee;
import com.qa.InspectorFacade.service.TraineeService;

import org.springframework.jms.core.JmsTemplate;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class TraineeRest {
	
	@Autowired
	private TraineeService service;
	
	@Autowired
	private MongoClientRest mongoclient;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.traineeQueue}")
	private String traineeQueuePath;
	
	@GetMapping("${path.getAllTrainees}")
    public ResponseEntity<String> getAllTrainees() {
		return mongoclient.readAllTraineesFromDatabase();
        //return service.getTrainees();
    }
	
	@PutMapping("${path.verifyLogin}")
	public Trainee verifyLoginDetails(@RequestBody Trainee trainee) {
		return service.verifyLoginDetails(trainee);
	}
	
	@GetMapping("${path.getTrainee}")
	public ResponseEntity<String> getTraineeByEmail(@PathVariable String email) {
		return mongoclient.readSingleTraineeFromDatabase(email);
		//return service.getTraineeByEmail(email);
	}
	
	@PostMapping("${path.createTrainee}")
    public Trainee createTrainee(@RequestBody Trainee trainee) {
		sendToQueue(trainee);
        return service.createTrainee(trainee);
    }
	
	@DeleteMapping("${path.deleteTrainee}")
	public String deleteTrainee(@PathVariable String email) {
		mongoclient.deleteTrainee(email);
		return "Trainee: " + email + " Deleted";
	}
	
	private void sendToQueue(Trainee trainee){
        SentTrainee traineeToStore =  new SentTrainee(trainee);
        traineeToStore.setTraineeId(10l);
        jmsTemplate.convertAndSend(traineeQueuePath, traineeToStore);
    }

}
