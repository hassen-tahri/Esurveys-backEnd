package com.Eseurveys.service;

import java.util.Date;
import java.util.List;

import com.Eseurveys.model.entity.Constat;

public interface ConstatService {
	Constat getConstatById(Long id);

	Constat addConstat(Constat constat);

	Constat updateConstat(Constat constat, Long id);

	List<Constat> getAll();

	List<Constat> getConstatByVoyage(Long idVoyage);

	List<Constat> getConstatByChargeur(Long idChargeur);

	List<Constat> getConstatByInspecteurChargement(Long idInCH);

	List<Constat> getConstatByInspecteurDechargemment(Long idInDch);
	
	List<Constat> getConstatByEtat(String etat);

	void deletConstat(Long id);
	
	List<Constat> getByDateChargementInRange(Date dateDeb , Date dateFin);
	
	List<Constat> getByDateDechargementInRange(Date dateDeb , Date dateFin);
	
	List<Constat> getByInspecteurChargementAndDateChargementInRange(Long id , Date dateDeb , Date dateFin);
	
	List<Constat> getByInspecteurDechargementAndDateChargementInRange(Long id , Date dateDeb , Date dateFin);
	
	List<Constat> getByChargeurAndEtat(Long id , String etat);
}
