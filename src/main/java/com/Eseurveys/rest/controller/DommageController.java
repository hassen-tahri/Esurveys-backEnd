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

import com.Eseurveys.model.entity.Dommage;
import com.Eseurveys.rest.dto.DommageDto;
import com.Eseurveys.service.DommageService;

@CrossOrigin("*")
@RestController
public class DommageController {

	@Autowired
	DommageService dommageService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/dommage/{id}")
	public Object getDommageById(@PathVariable Long id) {
		Dommage dommage = dommageService.getDommageById(id);
		DommageDto dommageDto = modelMapper.map(dommage, DommageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageDto);
	}

	@GetMapping("/dommage")
	public Object getAllDommage() {
		List<Dommage> dommages = dommageService.getAll();
		Type listType = new TypeToken<List<DommageDto>>() {
		}.getType();
		List<DommageDto> dommageDtos = modelMapper.map(dommages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageDtos);
	}

	@PostMapping("/dommage")
	public Object addDommage(@RequestBody DommageDto dommageDto) {
		Dommage dommage = modelMapper.map(dommageDto, Dommage.class);
		dommage = dommageService.addDommage(dommage);
		dommageDto = modelMapper.map(dommage, DommageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageDto);
	}

	@DeleteMapping("/dommage/{id}")
	public Object deleteDommage(@PathVariable Long id) {
		dommageService.deletDommage(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/dommage/{id}")
	public Object editDommage(@RequestBody DommageDto dommageDto, @PathVariable Long id) {
		Dommage dommage = modelMapper.map(dommageDto, Dommage.class);
		dommage = dommageService.updateDommage(dommage, id);
		dommageDto = modelMapper.map(dommage, DommageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(dommageDto);
	}

}
