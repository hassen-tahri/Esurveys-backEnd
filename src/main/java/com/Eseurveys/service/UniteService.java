package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.Unite;

public interface UniteService {
	Unite getById(Long id);

	Unite add(Unite unite);

	Unite update(Unite unite, Long id);

	List<Unite> getAll();

	void delet(Long id);

	Unite getByMatricule(String matricule);

	List<Unite> getByTypeRemorque(Long id);

}
