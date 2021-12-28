package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Voyage;
import java.util.List;
import java.lang.String;

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {

	List<Voyage> findByBateauId(Long id);

	List<Voyage> findByPortChargementId(Long id);

	List<Voyage> findByPortDechargementId(Long id);

	Voyage findByCode(String code);
	
	List<Voyage> findByEtat(String etat);
}
