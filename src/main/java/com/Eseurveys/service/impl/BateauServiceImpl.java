package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Bateau;
import com.Eseurveys.repository.BateauRepository;
import com.Eseurveys.service.BateauService;

@Service
public class BateauServiceImpl implements BateauService {

	@Autowired
	BateauRepository bateauRepository;

	@Override
	public Bateau getBateauById(Long id) {
		return bateauRepository.findById(id).get();
	}

	@Override
	public Bateau addBateau(Bateau bateau) {
		return bateauRepository.save(bateau);
	}

	@Override
	public Bateau updateBateau(Bateau bateau, Long id) {
		bateau.setId(id);
		return bateauRepository.save(bateau);
	}

	@Override
	public List<Bateau> getAll() {
		return (List<Bateau>) bateauRepository.findAll();
	}

	@Override
	public void deletBateau(Long id) {
		bateauRepository.deleteById(id);
	}

}
