package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.TypeRemorque;
import com.Eseurveys.repository.TypeRemorqueRepository;
import com.Eseurveys.service.TypeRemorqueService;

@Service
public class TypeRemorqueServiceImpl implements TypeRemorqueService {

	@Autowired
	TypeRemorqueRepository typeRepository;

	@Override
	public TypeRemorque getTypeById(Long id) {
		return typeRepository.findById(id).get();
	}

	@Override
	public TypeRemorque addType(TypeRemorque type) {
		return typeRepository.save(type);
	}

	@Override
	public TypeRemorque updateType(TypeRemorque type, Long id) {
		type.setId(id);
		return typeRepository.save(type);
	}

	@Override
	public List<TypeRemorque> getAll() {
		return (List<TypeRemorque>) typeRepository.findAll();
	}

	@Override
	public void deletType(Long id) {
		typeRepository.deleteById(id);

	}

}
