package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Dommage;
import com.Eseurveys.repository.DommageRepository;
import com.Eseurveys.service.DommageService;

@Service
public class DommageServiceImpl implements DommageService {

	@Autowired
	DommageRepository dommageRepository;
	
	@Override
	public Dommage getDommageById(Long id) {
		return dommageRepository.findById(id).get();
	}

	@Override
	public Dommage addDommage(Dommage dommage) {
		return dommageRepository.save(dommage);
	}

	@Override
	public Dommage updateDommage(Dommage dommage, Long id) {
		dommage.setId(id);
		return dommageRepository.save(dommage);
	}

	@Override
	public List<Dommage> getAll() {
		return (List<Dommage>) dommageRepository.findAll();
	}

	@Override
	public void deletDommage(Long id) {
		dommageRepository.deleteById(id);
		
	}

}
