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
import com.Eseurveys.model.entity.Unite;
import com.Eseurveys.rest.dto.UniteDto;
import com.Eseurveys.service.TypeRemorqueService;
import com.Eseurveys.service.UniteService;

@CrossOrigin("*")
@RestController
public class UniteController {

	@Autowired
	TypeRemorqueService typeService;

	@Autowired
	UniteService uniteService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/unite/{id}")
	public Object getById(@PathVariable Long id) {
		Unite unite = uniteService.getById(id);
		UniteDto uniteDto = modelMapper.map(unite, UniteDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteDto);
	}

	@GetMapping("/unite")
	public Object getAll() {
		List<Unite> unites = uniteService.getAll();
		Type listType = new TypeToken<List<UniteDto>>() {}.getType();
		List<UniteDto> uniteDtos = modelMapper.map(unites, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteDtos);
	}

	@PostMapping("/unite/type/{idT}")
	public Object addInspecteur(@RequestBody UniteDto uniteDto, @PathVariable Long idT) {
		Unite unite = modelMapper.map(uniteDto, Unite.class);
		try {
			TypeRemorque type = typeService.getTypeById(idT);
			unite.setTypeRemorque(type);
		} catch (Exception e) {
			unite.setTypeRemorque(null);
		}
		unite = uniteService.add(unite);
		uniteDto = modelMapper.map(unite, UniteDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteDto);
	}

	@PutMapping("/unite/{id}/type/{idT}")
	public Object edit(@RequestBody UniteDto uniteDto, @PathVariable Long id, @PathVariable Long idT) {
		Unite unite = modelMapper.map(uniteDto, Unite.class);
		try {
			TypeRemorque type = typeService.getTypeById(idT);
			unite.setTypeRemorque(type);
		} catch (Exception e) {
			unite.setTypeRemorque(null);
		}
		unite = uniteService.update(unite, id);
		uniteDto = modelMapper.map(unite, UniteDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteDto);
	}
	
	@DeleteMapping("/unite/{id}")
	public Object delete(@PathVariable Long id) {
		uniteService.delet(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/unite/matricule/{matricule}")
	public Object getByMatricule(@PathVariable String matricule) {
		Unite unite = uniteService.getByMatricule(matricule);
		UniteDto uniteDto = modelMapper.map(unite, UniteDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteDto);
	}
	
	@GetMapping("/unite/type/{idT}")
	public Object getAllByType(@PathVariable Long idT) {
		List<Unite> unites = uniteService.getByTypeRemorque(idT);
		Type listType = new TypeToken<List<UniteDto>>() {}.getType();
		List<UniteDto> uniteDtos = modelMapper.map(unites, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(uniteDtos);
	}
}
