package com.qa.InspectorFacade.persistence.domain;

public class SentReflectionForm {

	private Long formId;
	
	private Long traineeId;
	
	private String email;
	
	private int weekNumber;
	
	private int howsYourWeek;
	
	private String whatWentWell;
	
	private String howToKeepDoingWell;
	
	private String whatWentBad;
	
	private String howToStopDoingBad;
	
	public SentReflectionForm() {}
	
	public SentReflectionForm(Long traineeId, String email, int weekNumber, int howsYourWeek, String whatWentWell, String howToKeepDoingWell,
			String whatWentBad, String howToStopDoingBad) {
		
		this.traineeId = traineeId;
		this.email = email;
		this.weekNumber = weekNumber;
		this.howsYourWeek = howsYourWeek;
		this.whatWentWell = whatWentWell;
		this.howToKeepDoingWell = howToKeepDoingWell;
		this.whatWentBad = whatWentBad;
		this.howToStopDoingBad = howToStopDoingBad;
	}
	

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getHowsYourWeek() {
		return howsYourWeek;
	}

	public void setHowsYourWeek(int howsYourWeek) {
		this.howsYourWeek = howsYourWeek;
	}

	public String getWhatWentWell() {
		return whatWentWell;
	}

	public void setWhatWentWell(String whatWentWell) {
		this.whatWentWell = whatWentWell;
	}

	public String getHowToKeepDoingWell() {
		return howToKeepDoingWell;
	}

	public void setHowToKeepDoingWell(String howToKeepDoingWell) {
		this.howToKeepDoingWell = howToKeepDoingWell;
	}

	public String getWhatWentBad() {
		return whatWentBad;
	}

	public void setWhatWentBad(String whatWentBad) {
		this.whatWentBad = whatWentBad;
	}

	public String getHowToStopDoingBad() {
		return howToStopDoingBad;
	}

	public void setHowToStopDoingBad(String howToStopDoingBad) {
		this.howToStopDoingBad = howToStopDoingBad;
	}
	
	public Long getFormId() {
		return formId;
	}
	
	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
}
