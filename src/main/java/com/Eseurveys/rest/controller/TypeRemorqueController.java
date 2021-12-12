package com.Eseurveys.rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eseurveys.model.entity.TypeRemorque;
import com.Eseurveys.rest.dto.TypeRemorqueDto;
import com.Eseurveys.service.TypeRemorqueService;

@CrossOrigin("*")
@RestController
public class TypeRemorqueController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	TypeRemorqueService typeService;

	@GetMapping("/type/{id}")
	public Object getTypeById(@PathVariable Long id) {
		TypeRemorque type = typeService.getTypeById(id);
		TypeRemorqueDto typeDto = modelMapper.map(type, TypeRemorqueDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeDto);
	}

	@GetMapping("/type")
	public Object getAllType() {
		List<TypeRemorque> types = typeService.getAll();
		Type listType = new TypeToken<List<TypeRemorqueDto>>() {
		}.getType();
		List<TypeRemorqueDto> typeDtos = modelMapper.map(types, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeDtos);
	}

	@PostMapping("/type")
	public Object addType(@RequestBody TypeRemorqueDto typeDto) {
		TypeRemorque type = modelMapper.map(typeDto, TypeRemorque.class);
		type = typeService.addType(type);
		typeDto = modelMapper.map(type, TypeRemorqueDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeDto);
	}

	@DeleteMapping("/type/{id}")
	public Object deleteDommage(@PathVariable Long id) {
		typeService.deletType(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/type/{id}")
	public Object editDommage(@RequestBody TypeRemorqueDto typeDto, @PathVariable Long id) {
		TypeRemorque type = modelMapper.map(typeDto, TypeRemorque.class);
		type = typeService.updateType(type, id);
		typeDto = modelMapper.map(type, TypeRemorqueDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(typeDto);
	}

}
