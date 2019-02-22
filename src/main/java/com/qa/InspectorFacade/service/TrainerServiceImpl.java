package com.qa.InspectorFacade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.Trainer;
import com.qa.InspectorFacade.persistence.repository.TrainerRepo;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
	private TrainerRepo repo;
	
	public List<Trainer> getAllTrainers() {
		return repo.findAll();
	}
	
	public Trainer createTrainer(Trainer trainer) {
		return repo.save(trainer);
	}
	
	public ResponseEntity<Object> deleteTrainer(Long id) {
		if (trainerExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
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

	@Override
	public Trainer getTrainerByEmail(String email) {
		
		List<Trainer> trainerList = repo.findAll();
		for (Trainer trainer : trainerList) {
			if (trainer.getEmail().equals(email)) {
				return trainer;
			}
		}
		return null;
	}

}
