package com.Eseurveys.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Eseurveys.model.entity.ImageModel;
import java.lang.String;
import java.util.List;


public interface ImageModelReository extends JpaRepository<ImageModel, Long> {
	ImageModel findByName(String name);
	List<ImageModel> findByConstatId(Long id);
	List<ImageModel> findByConstatIdAndPhase(Long id, String phase);
}
