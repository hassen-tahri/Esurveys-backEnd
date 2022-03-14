package com.Eseurveys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Constat;
import com.Eseurveys.repository.ConstatRepository;
import com.Eseurveys.service.ConstatService;
@Service
public class ConstatServiceImpl implements ConstatService {

	@Autowired
	ConstatRepository constatRepository;

	@Override
	public Constat getConstatById(Long id) {
		return constatRepository.findById(id).get();
	}

	@Override
	public Constat addConstat(Constat constat) {
		return constatRepository.save(constat);
	}

	@Override
	public Constat updateConstat(Constat constat, Long id) {
		constat.setId(id);
		return constatRepository.save(constat);
	}

	@Override
	public List<Constat> getAll() {
		return (List<Constat>) constatRepository.findAll();
	}

	@Override
	public List<Constat> getConstatByVoyage(Long idVoyage) {
		return (List<Constat>) constatRepository.findByVoyageId(idVoyage);
	}

	@Override
	public List<Constat> getConstatByChargeur(Long idChargeur) {
		return (List<Constat>) constatRepository.findByChargeurId(idChargeur);
	}

	@Override
	public List<Constat> getConstatByInspecteurChargement(Long idInCH) {
		return (List<Constat>) constatRepository.findByInspecteurChargementId(idInCH);
	}

	@Override
	public List<Constat> getConstatByInspecteurDechargemment(Long idInDch) {
		return (List<Constat>) constatRepository.findByInspecteurDechargementId(idInDch);
	}

	@Override
	public void deletConstat(Long id) {
		constatRepository.deleteById(id);
	}

	@Override
	public List<Constat> getConstatByEtat(String etat) {
		return (List<Constat>) constatRepository.findByEtat(etat);
	}

	@Override
	public List<Constat> getByDateChargementInRange(Date dateDeb, Date dateFin) {
		return (List<Constat>) constatRepository.findByDateChargementBetween(dateDeb, dateFin);
	}

	@Override
	public List<Constat> getByDateDechargementInRange(Date dateDeb, Date dateFin) {
		return (List<Constat>) constatRepository.findByDateDechargementBetween(dateDeb, dateFin);
	}

	@Override
	public List<Constat> getByInspecteurChargementAndDateChargementInRange(Long id, Date dateDeb, Date dateFin) {
		return (List<Constat>) constatRepository.findByInspecteurChargementIdAndDateChargementBetween(id, dateDeb, dateFin);
	}

	@Override
	public List<Constat> getByInspecteurDechargementAndDateChargementInRange(Long id, Date dateDeb, Date dateFin) {
		return (List<Constat>) constatRepository.findByInspecteurDechargementIdAndDateChargementBetween(id, dateDeb, dateFin);
	}

	@Override
	public List<Constat> getByChargeurAndEtat(Long id, String etat) {
		return (List<Constat>) constatRepository.findByChargeurIdAndEtat(id, etat);
	}

}
