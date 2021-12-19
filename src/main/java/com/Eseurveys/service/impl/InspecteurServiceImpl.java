package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Inspecteur;
import com.Eseurveys.repository.InspecteurRepository;
import com.Eseurveys.service.InspecteurService;

@Service
public class InspecteurServiceImpl implements InspecteurService {

	@Autowired
	InspecteurRepository inspecteurRepository;

	@Override
	public Inspecteur getInpecteurById(Long id) {
		return inspecteurRepository.findById(id).get();
	}

	@Override
	public Inspecteur getInpecteurByUser(Long id) {
		return inspecteurRepository.findByUserId(id);
	}

	@Override
	public Inspecteur addInpecteur(Inspecteur inspecteur) {
		return inspecteurRepository.save(inspecteur);
	}

	@Override
	public Inspecteur updateInpecteur(Inspecteur inspecteur, Long id) {
		inspecteur.setId(id);
		return inspecteurRepository.save(inspecteur);
	}

	@Override
	public List<Inspecteur> getAll() {
		return (List<Inspecteur>) inspecteurRepository.findAll();
	}

	@Override
	public void deletInpecteur(Long id) {
		inspecteurRepository.deleteById(id);

	}

}
