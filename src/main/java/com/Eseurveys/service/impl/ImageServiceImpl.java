package com.Eseurveys.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Eseurveys.model.entity.ImageModel;
import com.Eseurveys.repository.ImageModelReository;

@Service
public class ImageServiceImpl {

	@Autowired
	ImageModelReository imageModelReository;
	
	public void saveImage(ImageModel imageModel) {
		imageModelReository.save(imageModel);	
	}

	public List<ImageModel> getAllActiveImages() {
		return imageModelReository.findAll();
	}

	public Optional<ImageModel> getImageById(Long id) {
		return imageModelReository.findById(id);
	}
	
//	public List<ImageModel> getAllImagesByConstatId(Long id) {
//		return imageModelReository.findByConstatId(id);
//	}
}
