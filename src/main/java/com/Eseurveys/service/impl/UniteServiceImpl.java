package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Unite;
import com.Eseurveys.repository.UniteRepository;
import com.Eseurveys.service.UniteService;

@Service
public class UniteServiceImpl implements UniteService {

	@Autowired
	UniteRepository uniteRepository;

	@Override
	public Unite getById(Long id) {
		return uniteRepository.findById(id).get();
	}

	@Override
	public Unite add(Unite unite) {
		return uniteRepository.save(unite);
	}

	@Override
	public Unite update(Unite unite, Long id) {
		unite.setId(id);
		return uniteRepository.save(unite);
	}

	@Override
	public List<Unite> getAll() {
		return (List<Unite>) uniteRepository.findAll();
	}

	@Override
	public void delet(Long id) {
		uniteRepository.deleteById(id);

	}

	@Override
	public Unite getByMatricule(String matricule) {
		return uniteRepository.findByMatricule(matricule);
	}

	@Override
	public List<Unite> getByTypeRemorque(Long id) {
		return uniteRepository.findByTypeRemorqueId(id);
	}

}
