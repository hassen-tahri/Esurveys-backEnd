package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eseurveys.model.entity.Chargeur;
import com.Eseurveys.model.entity.User;
import java.util.List;

@Repository
public interface ChargeurRepository extends JpaRepository<Chargeur, Long> {
	Chargeur findByUserId(Long id);
}
