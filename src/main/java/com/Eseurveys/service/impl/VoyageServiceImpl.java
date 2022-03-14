package com.Eseurveys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Voyage;
import com.Eseurveys.repository.VoyageRepository;
import com.Eseurveys.service.VoyageService;

@Service
public class VoyageServiceImpl implements VoyageService {

	@Autowired
	VoyageRepository voyageRepository;

	@Override
	public Voyage getVoyageById(Long id) {
		return voyageRepository.findById(id).get();
	}

	@Override
	public Voyage addVoyage(Voyage voyage) {
		return voyageRepository.save(voyage);
	}

	@Override
	public Voyage UpdateVoyage(Voyage voyage, Long id) {
		voyage.setId(id);
		return voyageRepository.save(voyage);
	}

	@Override
	public List<Voyage> getAll() {
		return (List<Voyage>) voyageRepository.findAll();
	}

	@Override
	public void deleteVoyage(Long id) {
		voyageRepository.deleteById(id);

	}

	@Override
	public List<Voyage> getByBateau(Long id) {
		return (List<Voyage>) voyageRepository.findByBateauId(id);
	}

	@Override
	public List<Voyage> getByPortChargement(Long id) {
		return (List<Voyage>) voyageRepository.findByPortChargementId(id);
	}

	@Override
	public List<Voyage> getByPortDechargement(Long id) {
		return (List<Voyage>) voyageRepository.findByPortDechargementId(id);
	}


	@Override
	public Voyage getByCode(String code) {
		return voyageRepository.findByCode(code);
	}

	@Override
	public List<Voyage> getByEtat(String etat) {
		return (List<Voyage>) voyageRepository.findByEtat(etat);
	}

	@Override
	public List<Voyage> getByArchive(Boolean archive) {
		return (List<Voyage>) voyageRepository.findByArchive(archive);
	}

	@Override
	public List<Voyage> getByDateChargementInRange(Date dateDeb, Date dateFin) {
		return (List<Voyage>) voyageRepository.findByDateChargementBetween(dateDeb, dateFin);
	}

}
