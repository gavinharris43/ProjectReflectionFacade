package com.qa.InspectorFacade.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.InspectorFacade.persistence.domain.Cohort;
import com.qa.InspectorFacade.persistence.domain.SentTrainee;
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
	
	@Value("${path.mongoGetSingleTraineeByEmail}")
	private String mongoClientGetTraineeByEmail;
	
	@Value("${path.mongoGetSingleTrainerByEmail}")
	private String mongoClientGetTrainerByEmail;
	
	@Value("${path.mongoGetSingleCohorBytName}")
	private String mongoClientGetCohortByName;
	
	@Value("${path.mongoDeleteTrainee}")
	private String mongoDeleteTrainee;
	
	@Value("${path.mongoDeleteTrainer}")
	private String mongoDeleteTrainer;
	
	@Value("${path.mongoDeleteCohort}")
	private String mongoDeleteCohort;
	
	@Value("${path.mongoGetAllFormsSpecificTraineeByEmail}")
	private String mongoGetAllFormsSpecificTraineeByEmail;
	
	@Value("${path.mongoDeleteForm}")
	private String mongoDeleteForm;
	
	public ResponseEntity<String> readSingleTraineeFromDatabase(String email) {
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetTraineeByEmail + email, String.class);
	}

	public ResponseEntity<String> readAllTraineesFromDatabase() {
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTraineesPath, String.class);
	}
	
	public String deleteTrainee(String email){
		restTemplate.delete(mongoURL + mongoClientServiceBasePath + mongoDeleteTrainee + email, String.class);
		return "Trainee Deleted";
	}
	
	public ResponseEntity<String> readSingleTrainerFromDatabase(String email) {	
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetAllTrainersPath + email, String.class);
	}

	public ResponseEntity<String> readAllTrainersFromDatabase() {
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath +  mongoClientGetTrainerByEmail, String.class);
	}
	
	public String deleteTrainer(String email){
		restTemplate.delete(mongoURL + mongoClientServiceBasePath + mongoDeleteTrainer + email, String.class);
		return "Trainer Deleted";
	}

	public ResponseEntity<String> readSingleCohortFromDatabase(String name) {
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetCohortByName + name, String.class);
	}

	public ResponseEntity<String> readAllCohortsFromDatabase() {
		return restTemplate.getForEntity(mongoURL + mongoClientServiceBasePath + mongoClientGetAllCohortsPath, String.class);
	}
	
	public String deleteCohort(String name){
		restTemplate.delete(mongoURL + mongoClientServiceBasePath + mongoDeleteCohort + name, String.class);
		return "Cohort Deleted";
	}
}
