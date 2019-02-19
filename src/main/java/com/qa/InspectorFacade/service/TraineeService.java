package com.qa.InspectorFacade.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface TraineeService {
	
	List<Trainee> getAccounts();

    Trainee addTrainee(Trainee trainee);

    ResponseEntity<Object> deleteTrainee(Long id);

    ResponseEntity<Object> updateTrainee(Trainee trainee, Long id);

}
