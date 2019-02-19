package com.qa.InspectorFacade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistance.repository.TraineeRepo;

@Service
public class TraineeServiceImpl {
	
	@Autowired
	private TraineeRepo repo;
	
	@Override
	public List<Trainee> getTrainees() {
		return repo.findAll();
	}
	
	@Override
	public Trainee createTrainee(Trainee trainee) {
		return repo.save(trainee);
	}
	
	@Override
	public ResponseEntity<Object> deleteTrainee(Long id) {
		if (traineeExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Override
	public ResponseEntity<Object> updateTrainee(Trainee trainee, Long id) {
		if (traineeExists(id)) {
			trainee.setTraineeID(id);
			repo.save(trainee);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	private boolean traineeExists(Long id){
        Optional<Trainee> traineeOptional = repo.findById(id);
        return traineeOptional.isPresent();
    }
	

}
