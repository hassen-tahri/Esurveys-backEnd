package com.Eseurveys.rest.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Eseurveys.model.entity.Constat;
import com.Eseurveys.model.entity.ImageModel;
import com.Eseurveys.repository.ImageModelReository;
import com.Eseurveys.service.ConstatService;

@CrossOrigin("*")
@RestController
public class ImageUploadController {

	@Autowired
	private ImageModelReository imageModelReository;

	@Autowired
	private ConstatService constatService;

	@PostMapping("constat/{id}/image/upload")
	public Object uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long id) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);

		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		Constat constat = constatService.getConstatById(id);
		img.setConstat(constat);
		imageModelReository.save(img);
		return ResponseEntity.status(HttpStatus.OK).body("image sent");
	}

	@GetMapping("constat/{id}/image/get")
	public Object getImage(@PathVariable Long id) throws IOException {
		final List<ImageModel> retrievedImages = imageModelReository.findByConstatId(id);
		for (ImageModel imageModel : retrievedImages) {
			imageModel.setPicByte(decompressBytes(imageModel.getPicByte()));
		}
//		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
//				decompressBytes(retrievedImage.get().getPicByte()));
		return retrievedImages;
	}

//	@DeleteMapping("constat/image/{id}")
//	public Object deleteImage(@PathVariable Long id) throws IOException {
//		final Optional<ImageModel> retrievedImage = imageModelReository.findByConstatId(id);
//		ImageModel img = retrievedImage.get();
//		imageModelReository.deleteById(img.getId());
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//
//	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[5120];
		//byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[5120];
		//byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
