package com.Eseurveys.rest.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoyageDto {
	private Long id;
	private String code;
	private String etat;
	private Boolean archive;
	private Date dateChargement;
	private Date dateDechargement;
	private BateauDto bateau;
	private PortDto portChargement;
	private PortDto portDechargement;
}
