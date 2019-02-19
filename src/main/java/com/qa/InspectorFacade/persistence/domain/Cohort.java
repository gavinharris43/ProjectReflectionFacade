package com.qa.InspectorFacade.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cohort {
	
	@Id
	@GeneratedValue
	private Long cohortId;
	
	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}

	private String cohortName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Trainee trainee;
	
	public Cohort() {
		
	}
	
	public Cohort(Long cohortId, String cohortName, Trainee trainee) {
		this.setCohortName(cohortName);
	}

	public String getCohortName() {
		return cohortName;
	}

	public void setCohortName(String cohortName) {
		this.cohortName = cohortName;
	}
	
	public Long getCohortId() {
		return cohortId;
	}
	
	public void setCohortName(Long cohortId) {
		this.cohortId = cohortId;
	}
	
	public Trainee getTrainee() {
		return trainee;
	}
	
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
}
