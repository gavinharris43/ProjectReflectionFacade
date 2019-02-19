package com.qa.InspectorFacade.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class TrainerRest {
	
	@Autowired
	private TrainerServiceImpl service;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("${path.getAllTrainer}")
    public List<Trainer> getTrainers() {
        return service.getAllTrainers();
    }
	
	@PostMapping("${path.createTrainer}")
    public Trainer createTrainer(@RequestBody Trainer trainer) {
		sendToQueue(trainer);
        return service.createTrainer(trainer);
    }
	
	@PutMapping("${path.updateTrainee}")
	public Trainer updateTrainer(@RequestBody Trainer trainer, @PathVariable Long id) {
		return service.updateTrainee(trainer, id);
	}
	
	@DeleteMapping("${path.deleteTrainer}")
	public Trainer deleteTrainer(@RequestBody Trainer trainer, @PathVariable Long id) {
		return service.deleteTrainer(trainer, id);
	}
	
	private void sendToQueue(Trainer trainer){
        SentTrainer traineeToStore =  new SentTrainer(trainer);
        jmsTemplate.convertAndSend("AccountQueue", trainerToStore);
    }

}
