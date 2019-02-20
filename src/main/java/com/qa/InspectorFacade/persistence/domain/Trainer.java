package com.qa.InspectorFacade.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue
	private Long trainerId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	public Trainer() {
		
	}
	
	public Trainer(String firstName, String lastName, String email, String password) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
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
