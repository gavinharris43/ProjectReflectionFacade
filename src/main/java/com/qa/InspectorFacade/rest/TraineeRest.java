package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class TraineeRest {
	
	@Autowired
	private TraineeService service;
	
	@GetMapping("${path.getAllTrainees}")
    public List<Trainee> getTrainees() {
        return service.getAllTrainees();
    }
	
	@PostMapping("${path.createTrainee}")
    public Trainee createTrainee(@RequestBody Trainee trainee) {
        return service.createTrainee(trainee);
    }
	
	@PutMapping("${path.updateTrainee}")
	public Trainee updateTrainee(@RequestBody Trainee trainee, @PathVariable Long id) {
		return service.updateTrainee(trainee, id);
	}
	
	@DeleteMapping("${path.deleteTrainee}")
	public Trainee deleteTrainee(@RequestBody Trainee trainee, @PathVariable Long id) {
		return service.deleteTrainee(trainee, id);
	}
	
	private void sendToQueue(Trainee trainee){
        SentTrainee traineeToStore =  new SentTrainee(trainee);
        jmsTemplate.convertAndSend("AccountQueue", traineeToStore);
    }

}
