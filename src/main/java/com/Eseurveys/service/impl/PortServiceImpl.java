package com.Eseurveys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.Port;
import com.Eseurveys.repository.PortRepository;
import com.Eseurveys.service.PortService;

@Service
public class PortServiceImpl implements PortService {

	@Autowired
	PortRepository portRepository;

	@Override
	public Port getPortById(Long id) {
		return portRepository.findById(id).get();
	}

	@Override
	public Port addPort(Port port) {
		return portRepository.save(port);
	}

	@Override
	public Port updatePort(Port port, Long id) {
		port.setId(id);
		return portRepository.save(port);
	}

	@Override
	public List<Port> getAll() {
		return (List<Port>) portRepository.findAll();
	}

	@Override
	public void deletPort(Long id) {
		portRepository.deleteById(id);

	}

}
