package com.Eseurveys.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BateauDto {
	private Long id;
	private String matricule;
	private String intitule;
}
