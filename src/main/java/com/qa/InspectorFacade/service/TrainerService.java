package com.qa.InspectorFacade.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TrainerService {
	
	List<Trainer> getTrainers();

    Trainer addTrainer(Trainer trainer);

    ResponseEntity<Object> deleteTrainer(Long id);

    ResponseEntity<Object> updateTrainer(Trainer trainer, Long id);

}
