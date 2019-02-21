package com.qa.InspectorFacade.persistence.domain;

public class SentTrainee {

	private Long traineeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String startDate;
	
	private Long cohortId;
	
	private float averageHowsYourWeek;
	
	private int currentHowsYourWeek;
	
	
	public SentTrainee() {
	
	}
	
	public SentTrainee(Trainee trainee) {
		this.traineeId = trainee.getTraineeId();
		this.firstName = trainee.getFirstName();
		this.lastName = trainee.getLastName();
		this.email = trainee.getEmail();
		this.password = trainee.getPassword();
		this.startDate = trainee.getStartDate();
		this.cohortId = trainee.getCohortId();
		this.averageHowsYourWeek = trainee.getAverageHowsYourWeek();
		this.currentHowsYourWeek = trainee.getCurrentHowsYourWeek();
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
	

	public Long getCohortId() {
		return cohortId;
	}

	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}

	public float getAverageHowsYourWeek() {
		return averageHowsYourWeek;
	}

	public void setAverageHowsYourWeek(float averageHowsYourWeek) {
		this.averageHowsYourWeek = averageHowsYourWeek;
	}

	public int getCurrentHowsYourWeek() {
		return currentHowsYourWeek;
	}

	public void setCurrentHowsYourWeek(int currentHowsYourWeek) {
		this.currentHowsYourWeek = currentHowsYourWeek;
	}


}