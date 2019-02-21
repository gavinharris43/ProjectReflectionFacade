package com.qa.InspectorFacade.persistence.domain;

public class SentTrainer {

	private Long trainerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	public SentTrainer() {
	}
	
	public SentTrainer(Trainer trainer) {
	
		this.trainerId = trainer.getTrainerId();
		this.firstName = trainer.getFirstName();
		this.lastName = trainer.getLastName();
		this.email = trainer.getEmail();
		this.password = trainer.getPassword();
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(Long trainerId){
		this.trainerId = trainerId;
	}
	

	
}