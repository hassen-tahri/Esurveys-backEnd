package com.Eseurveys.rest.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Eseurveys.model.entity.Constat;
import com.Eseurveys.model.entity.DommageItem;
import com.Eseurveys.model.entity.ImageModel;
import com.Eseurveys.repository.ImageModelReository;
import com.Eseurveys.rest.dto.DommageItemDto;
import com.Eseurveys.rest.dto.ImageModelDto;
import com.Eseurveys.rest.dto.UniteDto;
import com.Eseurveys.service.ConstatService;
import com.Eseurveys.service.impl.ImageServiceImpl;

@CrossOrigin("*")
@RestController
public class ImageUploadController {

	@Autowired
	private ImageModelReository imageModelReository;
	
	@Autowired
	private ImageServiceImpl imageService ;

	@Autowired
	private ConstatService constatService;
	
	@Autowired
	private ModelMapper modelMapper;

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


	@GetMapping("constat/{id}/image/getAll")
	public Object getAllImages(@PathVariable Long id) {
		List<ImageModel> listImage = imageModelReository.findByConstatId(id);
		for (int i = 0; i < listImage.size(); i++) {
			listImage.set(i, new ImageModel(listImage.get(i).getName(), listImage.get(i).getType(),
					decompressBytes(listImage.get(i).getPicByte())));
		}
		Type listType = new TypeToken<List<ImageModelDto>>() {
		}.getType();
		List<ImageModelDto> imageModelDtos = modelMapper.map(listImage, listType);
		return ResponseEntity.status(HttpStatus.CREATED).body(imageModelDtos);
	}
	
    @GetMapping("constat/{id}/image/get")
    public ImageModel getImage(@PathVariable Long id) throws IOException {
        final List<ImageModel> retrievedImage = imageModelReository.findByConstatId(id);
        ImageModel img = new ImageModel(retrievedImage.get(0).getName(), retrievedImage.get(0).getType(),
                decompressBytes(retrievedImage.get(0).getPicByte()));
        return img;
    }
	


	
	@DeleteMapping("constat/image/{name}")
	public Object deleteImage(@PathVariable String name) throws IOException {
		ImageModel ImageModel = imageModelReository.findByName(name);
		imageModelReository.delete(ImageModel);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[50240];
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
		byte[] buffer = new byte[50240];
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
