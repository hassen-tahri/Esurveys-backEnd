package com.Eseurveys.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DommageItemDto {
	private Long id;
	private String position;
	private String detail;
	private String longeur;
	private String largeur;
	private String unite;
	private String anciennete;
	private String dommageValue;
	private String phase;
	private DommageDto dommage;
	private ConstatDto constat;

}
