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

import com.Eseurveys.model.entity.Port;
import com.Eseurveys.rest.dto.PortDto;
import com.Eseurveys.service.PortService;

@CrossOrigin("*")
@RestController
public class PortController {

	@Autowired
	PortService portService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/port/{id}")
	public Object getPortById(@PathVariable Long id) {
		Port port = portService.getPortById(id);
		PortDto portDto = modelMapper.map(port, PortDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(portDto);
	}

	@GetMapping("/port")
	public Object getAllPort() {
		List<Port> ports = portService.getAll();
		Type listType = new TypeToken<List<PortDto>>() {
		}.getType();
		List<PortDto> portDtos = modelMapper.map(ports, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(portDtos);
	}

	@PostMapping("/port")
	public Object addPort(@RequestBody PortDto portDto) {
		Port port = modelMapper.map(portDto, Port.class);
		port = portService.addPort(port);
		portDto = modelMapper.map(port, PortDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(portDto);
	}

	@DeleteMapping("/port/{id}")
	public Object deletePort(@PathVariable Long id) {
		portService.deletPort(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	@PutMapping("/port/{id}")
	public Object editPort(@RequestBody PortDto portDto, @PathVariable Long id) {
		Port port = modelMapper.map(portDto, Port.class);
		port = portService.updatePort(port, id);
		portDto = modelMapper.map(port, PortDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(portDto);
	}

}
