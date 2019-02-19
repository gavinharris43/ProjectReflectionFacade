package com.qa.InspectorFacade.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepo extends JpaRepository<Cohort, Long> {

}
