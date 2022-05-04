package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.DommageItem;

public interface DommageItemService {

	DommageItem getById(Long id);

	DommageItem addItem(DommageItem item);

	DommageItem updateItem(DommageItem item, Long id);

	List<DommageItem> getAll();

	List<DommageItem> getByConstat(Long id);
	
	List<DommageItem> getByConstatAndPhase(Long id , String phase);
	
	void deletById(Long id);

}
