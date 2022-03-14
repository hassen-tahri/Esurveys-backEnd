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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eseurveys.model.entity.Chargeur;
import com.Eseurveys.model.entity.Constat;
import com.Eseurveys.model.entity.Inspecteur;
import com.Eseurveys.model.entity.TypeRemorque;
import com.Eseurveys.model.entity.Unite;
import com.Eseurveys.model.entity.Voyage;
import com.Eseurveys.rest.dto.ConstatDto;
import com.Eseurveys.service.ChargeurService;
import com.Eseurveys.service.ConstatService;
import com.Eseurveys.service.InspecteurService;
import com.Eseurveys.service.TypeRemorqueService;
import com.Eseurveys.service.UniteService;
import com.Eseurveys.service.VoyageService;

@CrossOrigin("*")
@RestController
public class ConstatController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ConstatService constatService;

	@Autowired
	private VoyageService voyageService;

	@Autowired
	private UniteService uniteService;

	@Autowired
	private ChargeurService chargeurService;

	@Autowired
	private InspecteurService inspecteurService;

	@GetMapping("/constat/{id}")
	public Object getConstatById(@PathVariable Long id) {
		Constat constat = constatService.getConstatById(id);
		ConstatDto constatDto = modelMapper.map(constat, ConstatDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDto);
	}

	@GetMapping("/constat")
	public Object getAllConstat() {
		List<Constat> constats = constatService.getAll();
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/voyage/{idVoyage}")
	public Object getAllConstatByVoyage(@PathVariable Long idVoyage) {
		List<Constat> constats = constatService.getConstatByVoyage(idVoyage);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/chargeur/{idChargeur}")
	public Object getAllConstatByChargeur(@PathVariable Long idChargeur) {
		List<Constat> constats = constatService.getConstatByChargeur(idChargeur);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/inspecteurChargement/{idInsCh}")
	public Object getAllConstatByInspecteurChargement(@PathVariable Long idInsCh) {
		List<Constat> constats = constatService.getConstatByInspecteurChargement(idInsCh);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/inspecteurDechargement/{idInsDch}")
	public Object getAllConstatByInspecteurDechargement(@PathVariable Long idInsDch) {
		List<Constat> constats = constatService.getConstatByInspecteurDechargemment(idInsDch);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/etat/{etat}")
	public Object getAllConstatByEtat(@PathVariable String etat) {
		List<Constat> constats = constatService.getConstatByEtat(etat);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@PostMapping("/constat/voyage/{idV}/chargeur/{idCh}/unite/{idU}/inspecteurCh/{idInsCh}/inspecteurDch/{idInsDch}")
	public Object addConstat(@RequestBody ConstatDto constatDto, @PathVariable Long idV, @PathVariable Long idCh,
			@PathVariable Long idU, @PathVariable Long idInsCh, @PathVariable Long idInsDch) {
		Constat constat = modelMapper.map(constatDto, Constat.class);
		try {
			Chargeur chargeur = chargeurService.getChargeurById(idCh);
			Unite unite = uniteService.getById(idU);
			Voyage voyage = voyageService.getVoyageById(idV);
			Inspecteur inspecteurCh = inspecteurService.getInpecteurById(idInsCh);
			Inspecteur inspecteurDch = inspecteurService.getInpecteurById(idInsDch);
			constat.setChargeur(chargeur);
			constat.setVoyage(voyage);
			constat.setInspecteurChargement(inspecteurCh);
			constat.setInspecteurDechargement(inspecteurDch);
			constat.setUnite(unite);
		} catch (Exception e) {
			constat.setChargeur(null);
			constat.setVoyage(null);
			constat.setInspecteurChargement(null);
			constat.setInspecteurDechargement(null);
			constat.setUnite(null);
		}
		constat = constatService.addConstat(constat);
		constatDto = modelMapper.map(constat, ConstatDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDto);
	}

	@PutMapping("/constat/{id}/voyage/{idV}/chargeur/{idCh}/unite/{idU}/inspecteurCh/{idInsCh}/inspecteurDch/{idInsDch}")
	public Object editChargeur(@RequestBody ConstatDto constatDto, @PathVariable Long id, @PathVariable Long idV,
			@PathVariable Long idCh, @PathVariable Long idU, @PathVariable Long idInsCh, @PathVariable Long idInsDch) {
		Constat constat = modelMapper.map(constatDto, Constat.class);
		try {
			Chargeur chargeur = chargeurService.getChargeurById(idCh);
			Unite unite = uniteService.getById(idU);
			Voyage voyage = voyageService.getVoyageById(idV);
			Inspecteur inspecteurCh = inspecteurService.getInpecteurById(idInsCh);
			Inspecteur inspecteurDch = inspecteurService.getInpecteurById(idInsDch);
			constat.setChargeur(chargeur);
			constat.setVoyage(voyage);
			constat.setInspecteurChargement(inspecteurCh);
			constat.setInspecteurDechargement(inspecteurDch);
			constat.setUnite(unite);
		} catch (Exception e) {
			constat.setChargeur(null);
			constat.setVoyage(null);
			constat.setInspecteurChargement(null);
			constat.setInspecteurDechargement(null);
			constat.setUnite(null);
		}
		constat = constatService.updateConstat(constat, id);
		constatDto = modelMapper.map(constat, ConstatDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDto);
	}

	@GetMapping("/constat/InspecteurChargement/RangeChargement/{id}/{dateDeb}/{dateFin}")
	public Object getByInspecteurChargementAndDateChargementInRange(@PathVariable Long id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDeb,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
		List<Constat> constats = constatService.getByInspecteurChargementAndDateChargementInRange(id, dateDeb, dateFin);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/InspecteurDechargement/RangeChargement/{id}/{dateDeb}/{dateFin}")
	public Object getByInspecteurDechargementAndDateChargementInRange(@PathVariable Long id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDeb,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
		List<Constat> constats = constatService.getByInspecteurDechargementAndDateChargementInRange(id, dateDeb,
				dateFin);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/RangeChargement/{dateDeb}/{dateFin}")
	public Object getByDateChargementInRange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDeb,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
		List<Constat> constats = constatService.getByDateChargementInRange(dateDeb, dateFin);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

	@GetMapping("/constat/RangeDechargement/{dateDeb}/{dateFin}")
	public Object getByDateDechargementInRange(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDeb,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
		List<Constat> constats = constatService.getByDateDechargementInRange(dateDeb, dateFin);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}
	
	@GetMapping("/constat/chargeur/{idChargeur}/etat/{etat}")
	public Object getConstatByChargeurAndEtat(@PathVariable Long idChargeur , @PathVariable String etat) {
		List<Constat> constats = constatService.getByChargeurAndEtat(idChargeur, etat);
		Type listType = new TypeToken<List<ConstatDto>>() {
		}.getType();
		List<ConstatDto> constatDtos = modelMapper.map(constats, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(constatDtos);
	}

}
