package com.Eseurveys.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Eseurveys.model.entity.ImageModel;
import java.lang.String;
import java.util.List;
import java.util.Optional;


public interface ImageModelReository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
	List<ImageModel> findByConstatId(Long id);

}
