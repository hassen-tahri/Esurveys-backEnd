package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.Inspecteur;

public interface InspecteurService {
	Inspecteur getInpecteurById(Long id);
	
	Inspecteur getInpecteurByUser(Long id);

	Inspecteur addInpecteur(Inspecteur inspecteur);

	Inspecteur updateInpecteur(Inspecteur inspecteur, Long id);

	List<Inspecteur> getAll();

	void deletInpecteur(Long id);

}
