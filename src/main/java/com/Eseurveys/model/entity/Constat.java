package com.Eseurveys.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "CONSTAT")
public class Constat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PLOMB_CODE")
	private Long plombCode;

	@Column(name = "REMARQUE", length = 60000)
	private String remarque;

	@Column(name = "EXPERTISE")
	private Boolean expertise;

	@Column(name = "INTERCHANGE")
	private Boolean interchange;

	@Column(name = "DATE_CHARGEMENT")
	@Temporal(value = TemporalType.DATE)
	private Date dateChargement;

	@Column(name = "DATE_DECHARGEMENT")
	@Temporal(value = TemporalType.DATE)
	private Date dateDechargement;

	@Column(name = "ETAT", length = 60000)
	private String etat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VOYAGE_ID")
	private Voyage voyage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNITE_ID")
	private Unite unite;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHARGEUREUR_ID")
	private Chargeur chargeur;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSPECTEUR_CHARGEMENT_ID")
	private Inspecteur inspecteurChargement;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INSPECTEUR_DECHARGEMENT_ID")
	private Inspecteur inspecteurDechargement;

	@OneToMany(mappedBy = "constat", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<DommageItem> dommageItems;
	
	@OneToMany(mappedBy = "constat", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<ImageModel> images;

}
