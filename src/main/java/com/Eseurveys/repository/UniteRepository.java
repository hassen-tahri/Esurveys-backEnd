package com.Eseurveys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Eseurveys.model.entity.Unite;
import java.util.List;
import java.lang.String;

public interface UniteRepository extends JpaRepository<Unite, Long> {

	List<Unite> findByTypeRemorqueId(Long id);

	Unite findByMatricule(String matricule);
}
