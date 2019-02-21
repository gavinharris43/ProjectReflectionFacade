package com.qa.InspectorFacade.rest;

import java.util.List;

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
	private JmsTemplate jmsTemplate;
	
	@Value("${queue.traineeQueue}")
	private String traineeQueuePath;
	
	@GetMapping("${path.getTrainee}")
    public List<Trainee> getTrainees() {
        return service.getTrainees();
    }
	
	@PostMapping("${path.createTrainee}")
    public Trainee createTrainee(@RequestBody Trainee trainee) {
		sendToQueue(trainee);
        return service.createTrainee(trainee);
    }
	
	@PutMapping("${path.updateTrainee}")
	public ResponseEntity<Object> updateTrainee(@RequestBody Trainee trainee, @PathVariable Long id) {
		return service.updateTrainee(trainee, id);
	}
	
	@DeleteMapping("${path.deleteTrainee}")
	public ResponseEntity<Object> deleteTrainee(@PathVariable Long id) {
		return service.deleteTrainee(id);
	}
	
	private void sendToQueue(Trainee trainee){
        SentTrainee traineeToStore =  new SentTrainee(trainee);
        jmsTemplate.convertAndSend(traineeQueuePath, traineeToStore);
    }

}
