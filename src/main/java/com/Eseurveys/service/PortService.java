package com.Eseurveys.service;

import java.util.List;
import com.Eseurveys.model.entity.Port;

public interface PortService {
	Port getPortById(Long id);

	Port addPort(Port port);

	Port updatePort(Port port, Long id);

	List<Port> getAll();

	void deletPort(Long id);

}
