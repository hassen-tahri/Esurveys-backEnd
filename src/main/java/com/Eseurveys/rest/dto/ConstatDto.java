package com.Eseurveys.rest.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstatDto {

	private Long id;

	private Long remorqueCode;

	private String plombCode;

	private String remarqueChargement;
	
	private String remarqueDechargement;

	private Boolean expertiseCh;

	private Boolean interchangeCh;
	
	private Boolean expertiseDch;
	
	private Boolean interchangeDch;
	
	private String etat;
	
	private String phase;
	
	private Date dateChargement;
	
	private Date dateDechargement;

	private VoyageDto voyage;

	private UniteDto unite;

	private ChargeurDto chargeur;

	private InspecteurDto inspecteurChargement;

	private InspecteurDto inspecteurDechargement;
	
	private Date dateCreation;

}
