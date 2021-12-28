package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.Bateau;

public interface BateauService {
	Bateau getBateauById(Long id);

	Bateau addBateau(Bateau bateau);

	Bateau updateBateau(Bateau bateau, Long id);

	List<Bateau> getAll();

	void deletBateau(Long id);

}
