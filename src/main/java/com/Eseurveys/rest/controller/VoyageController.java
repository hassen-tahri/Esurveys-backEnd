package com.Eseurveys.rest.controller;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.Eseurveys.model.entity.Port;
import com.Eseurveys.model.entity.Voyage;
import com.Eseurveys.rest.dto.VoyageDto;
import com.Eseurveys.service.BateauService;
import com.Eseurveys.service.PortService;
import com.Eseurveys.service.VoyageService;

@CrossOrigin("*")
@RestController
public class VoyageController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private VoyageService voyageService;

	@Autowired
	private PortService portService;

	@Autowired
	private BateauService bateauService;

	@GetMapping("/voyage")
	public Object getAllVoyage() {
		List<Voyage> voyages = voyageService.getAll();
		Type listType = new TypeToken<List<VoyageDto>>() {
		}.getType();
		List<VoyageDto> voyageDtos = modelMapper.map(voyages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDtos);
	}

	@GetMapping("/voyage/{id}")
	public Object getVoyageById(@PathVariable Long id) {
		Voyage voyage = voyageService.getVoyageById(id);
		VoyageDto voyageDto = modelMapper.map(voyage, VoyageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDto);
	}

	@GetMapping("/voyage/code/{code}")
	public Object getVoyageByCode(@PathVariable String code) {
		Voyage voyage = voyageService.getByCode(code);
		if (voyage != null) {
			VoyageDto voyageDto = modelMapper.map(voyage, VoyageDto.class);
			return ResponseEntity.status(HttpStatus.CREATED).body(voyageDto);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@GetMapping("/voyage/portChargement/{id}")
	public Object getByPortChargement(@PathVariable Long id) {
		List<Voyage> voyages = voyageService.getByPortChargement(id);
		Type listType = new TypeToken<List<VoyageDto>>() {
		}.getType();
		List<VoyageDto> voyageDtos = modelMapper.map(voyages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDtos);
	}

	@GetMapping("/voyage/portDechargement/{id}")
	public Object getByPortDechargement(@PathVariable Long id) {
		List<Voyage> voyages = voyageService.getByPortDechargement(id);
		Type listType = new TypeToken<List<VoyageDto>>() {
		}.getType();
		List<VoyageDto> voyageDtos = modelMapper.map(voyages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDtos);
	}

	@DeleteMapping("/voyage/{id}")
	public Object deleteVoyage(@PathVariable Long id) {
		voyageService.deleteVoyage(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PostMapping("/voyage/bateau/{idB}/portCh/{idPch}/portDch/{idPDch}")
	public Object addVoyage(@RequestBody VoyageDto voyageDto, @PathVariable("idB") Long idB,
			@PathVariable("idPch") Long idPch, @PathVariable("idPDch") Long idPDch) {
		Voyage voyage = modelMapper.map(voyageDto, Voyage.class);
		Port portCh = portService.getPortById(idPch);
		Port portDch = portService.getPortById(idPDch);
		Bateau bateau = bateauService.getBateauById(idB);
		voyage.setBateau(bateau);
		voyage.setPortChargement(portCh);
		voyage.setPortDechargement(portDch);
		voyage = voyageService.addVoyage(voyage);
		voyageDto = modelMapper.map(voyage, VoyageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDto);
	}

	@PutMapping("/voyage/{idV}/bateau/{idB}/portCh/{idPch}/portDch/{idPDch}")
	public Object UpdateVoyage(@RequestBody VoyageDto voyageDto, @PathVariable("idV") Long idV,
			@PathVariable("idB") Long idB, @PathVariable("idPch") Long idPch, @PathVariable("idPDch") Long idPDch) {
		Voyage voyage = modelMapper.map(voyageDto, Voyage.class);
		Port portCh = portService.getPortById(idPch);
		Port portDch = portService.getPortById(idPDch);
		Bateau bateau = bateauService.getBateauById(idB);
		voyage.setBateau(bateau);
		voyage.setPortChargement(portCh);
		voyage.setPortDechargement(portDch);
		voyage = voyageService.UpdateVoyage(voyage, idV);
		voyageDto = modelMapper.map(voyage, VoyageDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDto);
	}

	@GetMapping("/voyage/etat/{etat}")
	public Object getVoyageByEtat(@PathVariable String etat) {
		List<Voyage> voyages = voyageService.getByEtat(etat);
		Type listType = new TypeToken<List<VoyageDto>>() {
		}.getType();
		List<VoyageDto> voyageDtos = modelMapper.map(voyages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDtos);
	}

	@GetMapping("/voyage/archive/{archive}")
	public Object getVoyageByArchive(@PathVariable Boolean archive) {
		List<Voyage> voyages = voyageService.getByArchive(archive);
		Type listType = new TypeToken<List<VoyageDto>>() {
		}.getType();
		List<VoyageDto> voyageDtos = modelMapper.map(voyages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDtos);
	}

	@GetMapping("/voyage/RangeChargement/{dateDeb}/{dateFin}")
	public Object getByDateChargementInRange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDeb,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
		List<Voyage> voyages = voyageService.getByDateChargementInRange(dateDeb, dateFin);
		Type listType = new TypeToken<List<VoyageDto>>() {
		}.getType();
		List<VoyageDto> voyageDtos = modelMapper.map(voyages, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(voyageDtos);
	}
	
	@GetMapping("/voyage/CountByDateChargement/{date}")
	public Object countByDateChargement(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		int nbr = voyageService.getNbrVoyageByDateChargement(date);
		return ResponseEntity.status(HttpStatus.CREATED).body(nbr);
	}
	
	@GetMapping("/voyage/CountAll/")
	public Object countAll() {
		Integer nbr = voyageService.getAll().size();
		return ResponseEntity.status(HttpStatus.CREATED).body(nbr);
	}
	
}
