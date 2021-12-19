package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Inspecteur;

@Repository
public interface InspecteurRepository extends JpaRepository<Inspecteur, Long> {
	Inspecteur findByUserId(Long id);

}
