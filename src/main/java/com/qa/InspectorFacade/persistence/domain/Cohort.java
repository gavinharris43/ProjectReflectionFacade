package com.qa.InspectorFacade.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Cohort {
	
	@Id
	@GeneratedValue
	private Long cohortId;

	private String cohortName;
	
	
	public Cohort() {
		
	}
	
	public Cohort(String cohortName) {
		this.cohortName = cohortName;
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
	
	public void setCohortId(Long cohortId) {
		this.cohortId = cohortId;
	}
}
