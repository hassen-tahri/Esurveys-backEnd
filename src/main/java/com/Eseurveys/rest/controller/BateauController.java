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

import com.Eseurveys.model.entity.Bateau;
import com.Eseurveys.rest.dto.BateauDto;
import com.Eseurveys.service.BateauService;

@CrossOrigin("*")
@RestController
public class BateauController {

	@Autowired
	BateauService bateauService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/bateau/{id}")
	public Object getBateauById(@PathVariable Long id) {
		Bateau bateau = bateauService.getBateauById(id);
		BateauDto bateauDto = modelMapper.map(bateau, BateauDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(bateauDto);
	}

	@GetMapping("/bateau")
	public Object getAllBateau() {
		List<Bateau> bateaus = bateauService.getAll();
		Type listType = new TypeToken<List<BateauDto>>() {
		}.getType();
		List<BateauDto> bateauDtos = modelMapper.map(bateaus, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(bateauDtos);
	}

	@PostMapping("/bateau")
	public Object addBateau(@RequestBody BateauDto bateauDto) {
		Bateau bateau = modelMapper.map(bateauDto, Bateau.class);
		bateau = bateauService.addBateau(bateau);
		bateauDto = modelMapper.map(bateau, BateauDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(bateauDto);
	}

	@DeleteMapping("/bateau/{id}")
	public Object deleteBateau(@PathVariable Long id) {
		bateauService.deletBateau(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/bateau/{id}")
	public Object editPort(@RequestBody BateauDto bateauDto, @PathVariable Long id) {
		Bateau bateau = modelMapper.map(bateauDto, Bateau.class);
		bateau = bateauService.updateBateau(bateau, id);
		bateauDto = modelMapper.map(bateau, BateauDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(bateauDto);
	}

}