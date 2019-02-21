package com.qa.InspectorFacade.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	@Value("${path.mongoGetTrainee}")
	private String mongoClientGetSingleTraineePath;
	
	@Value("${path.mongoGetTrainer}")
	private String mongoClientGetSingleTrainerPath;
	
	@Value("${path.mongoGetCohort}")
	private String mongoClientGetSingleCohortPath;
	
	@Value("${path.mongoGetAllTrainees}")
	private String mongoClientGetAllTraineesPath;
	
	@Value("${path.mongoGetAllTrainers}")
	private String mongoClientGetAllTrainersPath;
	
	@Value("${path.mongoGetAllCohorts}")
	private String mongoClientGetAllCohortsPath;
	
	public ResponseEntity<String> readSingleTraineeFromDatabase(String email) {
		ResponseEntity<String> response = restTemplate.getForEntity(mongoURL + 
				mongoClientServiceBasePath + 
				mongoClientGetSingleTraineePath +
				email,
				String.class);
		return response;
	}
	
	public ResponseEntity<String> readAllTraineesFromDatabase() {
		ResponseEntity<String> response = restTemplate.getForEntity(mongoURL + 
				mongoClientServiceBasePath + 
				mongoClientGetAllTraineesPath, String.class);
		return response;
	}
	
	public ResponseEntity<String> readSingleTrainerFromDatabase() {
		ResponseEntity<String> response = restTemplate.getForEntity(mongoURL + 
				mongoClientServiceBasePath + 
				mongoClientGetSingleTrainerPath, String.class);
		return response;
	}
	
	public ResponseEntity<String> readAllTrainersFromDatabase() {
		ResponseEntity<String> response = restTemplate.getForEntity(mongoURL + 
				mongoClientServiceBasePath + 
				mongoClientGetAllTrainersPath, String.class);
		return response;
	}
	
	public ResponseEntity<String> readSingleCohortFromDatabase() {
		ResponseEntity<String> response = restTemplate.getForEntity(mongoURL + 
				mongoClientServiceBasePath + 
				mongoClientGetSingleCohortPath, String.class);
		return response;
	}
	
	public ResponseEntity<String> readAllCohortsFromDatabase() {
		ResponseEntity<String> response = restTemplate.getForEntity(mongoURL + 
				mongoClientServiceBasePath + 
				mongoClientGetAllCohortsPath, String.class);
		return response;
	}
	

}
