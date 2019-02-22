package com.qa.InspectorFacade.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.qa.InspectorFacade.persistence.domain.Trainee;

public interface TraineeService {
	
	List<Trainee> getTrainees();
	
	Trainee verifyLoginDetails(Trainee trainee);
	
	Trainee getTraineeByEmail(String email);

    Trainee createTrainee(Trainee trainee);

    ResponseEntity<Object> deleteTrainee(Long id);

    ResponseEntity<Object> updateTrainee(Trainee trainee, Long id);

}
