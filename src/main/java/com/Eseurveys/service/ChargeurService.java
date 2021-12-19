package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.Chargeur;

public interface ChargeurService {
	Chargeur getChargeurById(Long id);

	Chargeur addChargeur(Chargeur chargeur);

	Chargeur updateChargeur(Chargeur chargeur, Long id);

	List<Chargeur> getAll();

	Chargeur getChargeurByUser(Long iduser);

	void deletChargeur(Long id);

}
