package com.qa.InspectorFacade.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainee {
	
	@Id
	@GeneratedValue
	private Long traineeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String startDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	private ReflectionForm reflectionForm;
	
	public Trainee() {
		
	}
	
	public Trainee(Long traineeId, String firstName, String lastName, String email, String password, String startDate) {
		this.setTraineeId(traineeId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
		this.setStartDate(startDate);
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
	
	public Long getTraineeId() {
		return traineeId;
	}
	
	public void setTraineeId(Long traineeId){
		this.traineeId = traineeId;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public ReflectionForm getForm() {
		return reflectionForm;
	}
	
	public void setForm(ReflectionForm reflectionForm) {
		this.reflectionForm = reflectionForm;
	}


}
