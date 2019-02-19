package com.qa.InspectorFacade.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.InspectorFacade.persistence.domain.Trainer;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {

}
