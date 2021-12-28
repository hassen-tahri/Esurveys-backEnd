package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Port;

@Repository
public interface PortRepository extends JpaRepository<Port, Long>{

}
