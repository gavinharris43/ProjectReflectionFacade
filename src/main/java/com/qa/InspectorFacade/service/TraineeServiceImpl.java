package com.qa.InspectorFacade.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.InspectorFacade.persistence.domain.Trainee;
import com.qa.InspectorFacade.persistence.domain.Trainer;
import com.qa.InspectorFacade.persistence.repository.TraineeRepo;

@Service
public class TraineeServiceImpl implements TraineeService {

	@Autowired
	private TraineeRepo repo;

	public List<Trainee> getTrainees() {
		return repo.findAll();
	}
	
	public Trainee verifyLoginDetails(Trainee trainee) {
		
		ArrayList<Trainee> allTrainees = (ArrayList<Trainee>) repo.findAll();
		ArrayList<Trainee> theTrainee = new ArrayList<Trainee>();

		theTrainee = (ArrayList<Trainee>) allTrainees.stream()
				.filter(x -> (trainee.getEmail().equals(x.getEmail())) && trainee.getPassword().equals(x.getPassword()))
				.collect(Collectors.toList());

		if (theTrainee.size() == 1) {
			return theTrainee.get(0);
		} 
		else {

		return null;
		}
		
	}

	public Trainee getTraineeByEmail(String email) {
		List<Trainee> traineeList = repo.findAll();
		for (Trainee trainee : traineeList) {
			if (trainee.getEmail().equals(email)) {
				return trainee;
			}
		}
		return null;
	}

	public Trainee createTrainee(Trainee trainee) {
		return repo.save(trainee);
	}

	public ResponseEntity<Object> deleteTrainee(Long id) {
		if (traineeExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	public ResponseEntity<Object> updateTrainee(Trainee trainee, Long id) {
		if (traineeExists(id)) {
			trainee.setTraineeId(id);
			repo.save(trainee);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	private boolean traineeExists(Long id) {
		Optional<Trainee> traineeOptional = repo.findById(id);
		return traineeOptional.isPresent();
	}

}
