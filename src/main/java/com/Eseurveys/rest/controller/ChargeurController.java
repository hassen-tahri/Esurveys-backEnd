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

import com.Eseurveys.model.entity.Chargeur;
import com.Eseurveys.model.entity.User;
import com.Eseurveys.rest.dto.ChargeurDto;
import com.Eseurveys.service.ChargeurService;
import com.Eseurveys.service.UserService;

@CrossOrigin("*")
@RestController
public class ChargeurController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ChargeurService chargeurService;

	@Autowired
	UserService userService;

	@GetMapping("/chargeur/{id}")
	public Object getChargeurById(@PathVariable Long id) {
		Chargeur chargeur = chargeurService.getChargeurById(id);
		ChargeurDto chargeurDto = modelMapper.map(chargeur, ChargeurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(chargeurDto);
	}

	@GetMapping("/chargeur")
	public Object getAllChargeur() {
		List<Chargeur> chargeurs = chargeurService.getAll();
		Type listType = new TypeToken<List<ChargeurDto>>() {
		}.getType();
		List<ChargeurDto> chargeurDtos = modelMapper.map(chargeurs, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(chargeurDtos);
	}

	@GetMapping("/chargeur/user/{id}")
	public Object getchargeurByUserId(@PathVariable Long id) {
		Chargeur chargeur = chargeurService.getChargeurByUser(id);
		ChargeurDto chargeurDto = modelMapper.map(chargeur, ChargeurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(chargeurDto);
	}

	@PostMapping("/chargeur/user/{idUser}")
	public Object addChargeur(@RequestBody ChargeurDto chargeurDto, @PathVariable("idUser") Long idUser) {
		Chargeur chargeur = modelMapper.map(chargeurDto, Chargeur.class);
		try {
			User user = userService.getUserById(idUser);
			chargeur.setUser(user);
		} catch (Exception e) {
			chargeur.setUser(null);
		}
		chargeur = chargeurService.addChargeur(chargeur);
		chargeurDto = modelMapper.map(chargeur, ChargeurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(chargeurDto);
	}

	@DeleteMapping("/chargeur/{id}")
	public Object deleteChargeur(@PathVariable Long id) {
		chargeurService.deletChargeur(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/chargeur/{id}/user/{idUser}")
	public Object editChargeur(@RequestBody ChargeurDto chargeurDto, @PathVariable Long id,
			@PathVariable("idUser") Long idUser) {
		Chargeur chargeur = modelMapper.map(chargeurDto, Chargeur.class);
		try {
			User user = userService.getUserById(idUser);
			chargeur.setUser(user);
		} catch (Exception e) {
			chargeur.setUser(null);
		}
		chargeur = chargeurService.updateChargeur(chargeur, id);
		chargeurDto = modelMapper.map(chargeur, ChargeurDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(chargeurDto);
	}

}
