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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Eseurveys.model.entity.Constat;
import com.Eseurveys.model.entity.Dommage;
import com.Eseurveys.model.entity.DommageItem;
import com.Eseurveys.rest.dto.DommageItemDto;
import com.Eseurveys.rest.dto.UniteDto;
import com.Eseurveys.service.ConstatService;
import com.Eseurveys.service.DommageItemService;
import com.Eseurveys.service.DommageService;

@CrossOrigin("*")
@RestController
public class DommageItemController {

	@Autowired
	DommageService dommageService;

	@Autowired
	DommageItemService itemService;

	@Autowired
	ConstatService constatService;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/dommageItem/{id}")
	public Object getById(@PathVariable Long id) {
		DommageItem item = itemService.getById(id);
		DommageItemDto itemDto = modelMapper.map(item, DommageItemDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDto);
	}
	
	@GetMapping("/dommageItem")
	public Object getAll() {
		List<DommageItem> items = itemService.getAll();
		Type listType = new TypeToken<List<UniteDto>>() {}.getType();
		List<DommageItemDto> itemDtos = modelMapper.map(items, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDtos);
	}
	
	@PostMapping("/dommageItem/dommage/{idD}/constat/{idC}")
	public Object add(@RequestBody DommageItemDto itemDto, @PathVariable Long idD, @PathVariable Long idC) {
		DommageItem item = modelMapper.map(itemDto, DommageItem.class);
		try {
			Constat constat = constatService.getConstatById(idC);
			Dommage dommage = dommageService.getDommageById(idD);
			item.setConstat(constat);
			item.setDommage(dommage);
		} catch (Exception e) {
			item.setConstat(null);
			item.setDommage(null);
		}
		item = itemService.addItem(item);
		itemDto = modelMapper.map(item, DommageItemDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDto);
	}
	
	@PostMapping("/dommageItem/{id}/dommage/{idD}/constat/{idC}")
	public Object edit(@RequestBody DommageItemDto itemDto, @PathVariable Long id ,@PathVariable Long idD, @PathVariable Long idC) {
		DommageItem item = modelMapper.map(itemDto, DommageItem.class);
		try {
			Constat constat = constatService.getConstatById(idC);
			Dommage dommage = dommageService.getDommageById(idD);
			item.setConstat(constat);
			item.setDommage(dommage);
		} catch (Exception e) {
			item.setConstat(null);
			item.setDommage(null);
		}
		item = itemService.updateItem(item, id);
		itemDto = modelMapper.map(item, DommageItemDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDto);
	}
	
	
	@DeleteMapping("/dommageItem/{id}")
	public Object delete(@PathVariable Long id) {
		itemService.deletById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/dommageItem/constat/{idC}")
	public Object getByConstat(@PathVariable Long idC) {
		List<DommageItem> items = itemService.getByConstat(idC);
		Type listType = new TypeToken<List<UniteDto>>() {}.getType();
		List<DommageItemDto> itemDtos = modelMapper.map(items, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemDtos);
	}
	

}
