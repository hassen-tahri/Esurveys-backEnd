package com.Eseurveys.rest.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeurDto {
	private Long id;
	private String intitule;
	private String pays;
	private String email;
	private String numTel;
	private String adresse;
	private UserDto user;
}
