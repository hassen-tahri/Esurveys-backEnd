package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.DommageItem;
import com.Eseurveys.repository.DommageItemRepository;
import com.Eseurveys.service.DommageItemService;

@Service
public class DommageItemServiceImpl implements DommageItemService {

	@Autowired
	DommageItemRepository itemRepository;

	@Override
	public DommageItem getById(Long id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public DommageItem addItem(DommageItem item) {
		return itemRepository.save(item);
	}

	@Override
	public DommageItem updateItem(DommageItem item, Long id) {
		item.setId(id);
		return itemRepository.save(item);
	}

	@Override
	public List<DommageItem> getAll() {
		return (List<DommageItem>) itemRepository.findAll();
	}

	@Override
	public List<DommageItem> getByConstat(Long id) {
		return (List<DommageItem>) itemRepository.findByConstatId(id);
	}

	@Override
	public void deletById(Long id) {
		itemRepository.deleteById(id);
		
	}

	@Override
	public List<DommageItem> getByConstatAndPhase(Long id, String phase) {
		return (List<DommageItem>) itemRepository.findByConstatIdAndPhase(id, phase);
	}

}
