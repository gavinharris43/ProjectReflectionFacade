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
	private JmsTemplate jmsTemplate;
	
	@GetMapping("${path.getTrainer}")
    public List<Trainer> getTrainers() {
        return service.getTrainers();
    }
	
	@PostMapping("${path.createTrainer}")
    public Trainer createTrainer(@RequestBody Trainer trainer) {
		sendToQueue(trainer);
        return service.createTrainer(trainer);
    }
	
	@PutMapping("${path.updateTrainer}")
	public ResponseEntity<Object> updateTrainer(@RequestBody Trainer trainer, @PathVariable Long id) {
		return service.updateTrainer(trainer, id);
	}
	
	@DeleteMapping("${path.deleteTrainer}")
	public ResponseEntity<Object> deleteTrainer(@PathVariable Long id) {
		return service.deleteTrainer(id);
	}
	
	private void sendToQueue(Trainer trainer){
        SentTrainer trainerToStore =  new SentTrainer(trainer);
        jmsTemplate.convertAndSend("TrainerQueue", trainerToStore);
    }

}
