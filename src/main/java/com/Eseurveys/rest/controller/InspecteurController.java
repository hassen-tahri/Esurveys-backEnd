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

import com.Eseurveys.model.entity.Inspecteur;
import com.Eseurveys.model.entity.User;
import com.Eseurveys.rest.dto.InspecteurDto;
import com.Eseurveys.service.InspecteurService;
import com.Eseurveys.service.UserService;

@CrossOrigin("*")
@RestController
public class InspecteurController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	InspecteurService inspecteurService;

	@Autowired
	UserService userService;

	@GetMapping("/inspecteur/{id}")
	public Object getInspecteurById(@PathVariable Long id) {
		Inspecteur inspecteur = inspecteurService.getInpecteurById(id);
		InspecteurDto inspecteurDto = modelMapper.map(inspecteur, InspecteurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(inspecteurDto);
	}

	@GetMapping("/inspecteur")
	public Object getAllInspecteur() {
		List<Inspecteur> inspecteurs = inspecteurService.getAll();
		Type listType = new TypeToken<List<InspecteurDto>>() {
		}.getType();
		List<InspecteurDto> inspecteurDtos = modelMapper.map(inspecteurs, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(inspecteurDtos);
	}

	@PostMapping("/inspecteur/user/{idUser}")
	public Object addInspecteur(@RequestBody InspecteurDto inspecteurDto, @PathVariable("idUser") Long idUser) {
		Inspecteur inspecteur = modelMapper.map(inspecteurDto, Inspecteur.class);
		try {
			User user = userService.getUserById(idUser);
			inspecteur.setUser(user);
		} catch (Exception e) {
			inspecteur.setUser(null);
		}
		inspecteur = inspecteurService.addInpecteur(inspecteur);
		inspecteurDto = modelMapper.map(inspecteur, InspecteurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(inspecteurDto);
	}

	@DeleteMapping("/inspecteur/{id}")
	public Object deleteInspecteur(@PathVariable Long id) {
		inspecteurService.deletInpecteur(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/inspecteur/{id}/user/{idUser}")
	public Object editInspecteur(@RequestBody InspecteurDto inspecteurDto, @PathVariable Long id,
			@PathVariable("idUser") Long idUser) {
		Inspecteur inspecteur = modelMapper.map(inspecteurDto, Inspecteur.class);
		try {
			User user = userService.getUserById(idUser);
			//inspecteur.setUser(user);
		} catch (Exception e) {
			//inspecteur.setUser(null);
		}
		inspecteur = inspecteurService.updateInpecteur(inspecteur, id);
		inspecteurDto = modelMapper.map(inspecteur, InspecteurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(inspecteurDto);
	}

}
