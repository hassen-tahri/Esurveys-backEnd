package com.Eseurveys.service;

import java.util.Date;
import java.util.List;

import com.Eseurveys.model.entity.Voyage;

public interface VoyageService {
	Voyage getVoyageById(Long id);

	Voyage addVoyage(Voyage voyage);

	Voyage UpdateVoyage(Voyage voyage, Long id);

	List<Voyage> getAll();

	void deleteVoyage(Long id);

	List<Voyage> getByBateau(Long id);

	List<Voyage> getByPortChargement(Long id);

	List<Voyage> getByPortDechargement(Long id);
	
	List<Voyage> getByEtat(String etat);

	Voyage getByCode(String code);
	
	List<Voyage> getByArchive(Boolean archive);
	
	List<Voyage> getByDateChargementInRange(Date dateDeb , Date dateFin);
	
	Integer getNbrVoyageByDateChargement(Date date);
	
}
