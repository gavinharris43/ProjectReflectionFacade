package com.qa.InspectorFacade.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.InspectorFacade.persistence.domain.Cohort;

@Repository
public interface CohortRepo extends JpaRepository<Cohort, Long> {

}
