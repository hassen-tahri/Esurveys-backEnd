package com.Eseurveys.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DommageItemDto {

	private String position;
	private String detail;
	private String longeur;
	private String largeur;
	private String anciennete;
	private String dommageValue;
	private DommageDto dommage;
	private ConstatDto constat;

}
