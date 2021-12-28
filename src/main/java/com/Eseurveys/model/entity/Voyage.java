package com.Eseurveys.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VOYAGE")
public class Voyage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODE", length = 1000)
	private String code;
	
	@Column(name = "ETAT", length = 1000)
	private String etat;

	@Column(name = "DATE_CHARGEMENT")
	@Temporal(value = TemporalType.DATE)
	private Date dateChargement;

	@Column(name = "DATE_DECHARGEMENT")
	@Temporal(value = TemporalType.DATE)
	private Date dateDechargement;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BATEAU_ID")
	private Bateau bateau;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PORT_CHARGEMENT_ID")
	private Port portChargement;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PORT_DECHARGEMENT_ID")
	private Port portDechargement;
}
