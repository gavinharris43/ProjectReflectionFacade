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

import com.qa.InspectorFacade.persistence.domain.SentTrainer;
import com.qa.InspectorFacade.persistence.domain.Trainer;
import com.qa.InspectorFacade.service.TrainerService;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class TrainerRest {
	
	@Autowired
	private TrainerService service;
	
	@Autowired
	private MongoClientRest mongoClient;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.trainerQueue}")
	private String trainerQueuePath;
	
	@GetMapping("/path/getAllTrainers")
    public ResponseEntity<String> getAllTrainers() {
        return mongoClient.readAllTrainersFromDatabase();
    }
	
	@GetMapping("${path.getTrainer}")
	public ResponseEntity<String> getTrainerByEmail(String email) {
		return mongoClient.readSingleTrainerFromDatabase(email);
	}
	
	@PostMapping("${path.createTrainer}")
    public Trainer createTrainer(@RequestBody Trainer trainer) {
		sendToQueue(trainer);
        return service.createTrainer(trainer);
    }
	
	@DeleteMapping("${path.deleteTrainer}")
	public String deleteTrainer(@PathVariable String email) {
		return mongoClient.deleteTrainer(email);
	}
	
	private void sendToQueue(Trainer trainer){
        SentTrainer trainerToStore =  new SentTrainer(trainer);
        jmsTemplate.convertAndSend(trainerQueuePath, trainerToStore);
    }

}
