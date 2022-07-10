package com.Eseurveys.rest.dto;



import com.Eseurveys.model.entity.Constat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageModelDto {

	private Long id;

	private String name;

	private String type;

	private byte[] picByte;
	
	private String phase;

	private ConstatDto constat;

}
