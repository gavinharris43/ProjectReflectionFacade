package com.qa.InspectorFacade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.qa.InspectorFacade.persistance.repository.TrainerRepo;
import com.qa.InspectorFacade.persistence.domain.Trainer;

public class TrainerServiceImpl {
	
	@Autowired
	private TrainerRepo repo;
	
	@Override
	public List<Trainer> getTrainers() {
		return repo.findAll();
	}
	
	@Override
	public Trainer createTrainer(Trainer trainer) {
		return repo.save(trainer);
	}
	
	@Override
	public ResponseEntity<Object> deleteTrainer(Long id) {
		if (trainerExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Override
	public ResponseEntity<Object> updateTrainer(Trainer trainer, Long id) {
		if (trainerExists(id)) {
			trainer.setTrainerId(id);
			repo.save(trainer);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	private boolean trainerExists(Long id){
        Optional<Trainer> trainerOptional = repo.findById(id);
        return trainerOptional.isPresent();
    }

}
