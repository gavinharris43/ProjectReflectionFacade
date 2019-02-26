package com.qa.InspectorFacade.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.InspectorFacade.persistence.domain.Cohort;
import com.qa.InspectorFacade.persistence.domain.Trainee;
import com.qa.InspectorFacade.persistence.domain.Trainer;

@CrossOrigin
@RequestMapping("${path.base}")
@RestController
public class MongoClientRest {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${url.mongoclient}")
	private String mongoURL;

	@Value("${path.mongoClientServiceBasePath}")
	private String mongoClientServiceBasePath;

	@Value("${path.mongoGetAllTrainees}")
	private String mongoClientGetAllTraineesPath;

	@Value("${path.mongoGetAllTrainers}")
	private String mongoClientGetAllTrainersPath;

	@Value("${path.mongoGetAllCohorts}")
	private String mongoClientGetAllCohortsPath;
	
	@Value("${path.mongoGetSingleTraineeByID}")
	private String mongoClientGetTraineeById;
	
	@Value("${path.mongoGetSingleTraineeByEmail}")
	private String mongoClientGetTraineeByEmail;
	
	@Value("${path.mongoGetSingleTrainerByEmail}")
	private String mongoClientGetTrainerByEmail;
	
	@Value("${path.mongoGetSingleCohorBytName}")
	private String mongoClientGetCohortByEmail;
	
	@Value("${path.mongoDeleteTrainee}")
	private String mongoDeleteTrainee;
	
	@Value("${path.mongoDeleteTrainer}")
	private String mongoDeleteTrainer;


	public Trainee readTraineeById(Long id) {
		return restTemplate.getForObject(mongoURL + mongoClientServiceBasePath + mongoClientGetTraineeById + id, Trainee.class);
	}
	
	public Trainee readSingleTraineeFromDatabase(String email) {
		return restTemplate.getForObject(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTraineesPath + email, Trainee.class);
	}

	public ResponseEntity<String> readAllTraineesFromDatabase() {
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTraineesPath, String.class);
	}
	
	public void deleteTrainee(String email){
		restTemplate.delete(mongoURL + mongoClientServiceBasePath + mongoDeleteTrainee + email, String.class);
	}
	
	public Trainee updateTrainee(String email) {
		return null;
	}

	public Trainer readSingleTrainerFromDatabase(String email) {
		
		return restTemplate.getForObject(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTrainersPath + email, Trainer.class);
	}

	
	public ResponseEntity<String> readAllTrainersFromDatabase() {
		ResponseEntity<String> response = restTemplate
				.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTrainersPath, String.class);

		return response;
	}
	
	public ResponseEntity<String> deleteTrainer(String email){
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoDeleteTrainer + email, String.class);
	}

	public Cohort readSingleCohortFromDatabase(String name) {

		return restTemplate.getForObject(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTrainersPath + name, Cohort.class);
	}

	public ResponseEntity<String> readAllCohortsFromDatabase() {
		ResponseEntity<String> cohorts = restTemplate
				.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetAllCohortsPath, String.class);
		return null;
	}
}
