package com.qa.InspectorFacade.persistence.domain;


public class SentCohort {
	
	private Long cohortId;
	private String cohortName;
	
	public SentCohort() {	
	}
	
	public SentCohort(Cohort cohort) {
		this.cohortId = cohort.getCohortId();
		this.cohortName = cohort.getCohortName();
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

