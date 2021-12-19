package com.Eseurveys.rest.dto;

import com.Eseurveys.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspecteurDto {
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String numTel;
	private UserDto user;
}
