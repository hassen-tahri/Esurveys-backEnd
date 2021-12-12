package com.Eseurveys.service;

import java.util.List;

import com.Eseurveys.model.entity.TypeRemorque;

public interface TypeRemorqueService {
	TypeRemorque getTypeById(Long id);

	TypeRemorque addType(TypeRemorque type);

	TypeRemorque updateType(TypeRemorque type, Long id);

	List<TypeRemorque> getAll();

	void deletType(Long id);

}
