package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Chargeur;
import com.Eseurveys.repository.ChargeurRepository;
import com.Eseurveys.service.ChargeurService;

@Service
public class ChargeurServiceImpl implements ChargeurService {

	@Autowired
	ChargeurRepository chargeurRepository;

	@Override
	public Chargeur getChargeurById(Long id) {
		return chargeurRepository.findById(id).get();
	}

	@Override
	public Chargeur addChargeur(Chargeur chargeur) {
		return chargeurRepository.save(chargeur);
	}

	@Override
	public Chargeur updateChargeur(Chargeur chargeur, Long id) {
		chargeur.setId(id);
		return chargeurRepository.save(chargeur);
	}

	@Override
	public List<Chargeur> getAll() {
		return (List<Chargeur>) chargeurRepository.findAll();
	}

	@Override
	public Chargeur getChargeurByUser(Long idUser) {
		return chargeurRepository.findByUserId(idUser);
	}

	@Override
	public void deletChargeur(Long id) {
		chargeurRepository.deleteById(id);

	}

}
