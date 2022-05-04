package com.Eseurveys.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "DOMMAGE_ITEM")
public class DommageItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "POSITION", length = 1000)
	private String position;

	@Column(name = "DETAIL", length = 1000)
	private String detail;

	@Column(name = "LONGUER", length = 1000)
	private String longeur;

	@Column(name = "LARGEUR", length = 1000)
	private String largeur;
	
	@Column(name = "UNITE", length = 1000)
	private String unite;

	@Column(name = "ANCIENNETE", length = 1000)
	private String anciennete;

	@Column(name = "DOMMAGE_VALUE", length = 1000)
	private String dommageValue;
	
	@Column(name = "PHASE", length = 1000)
	private String phase;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOMMAGE_ID")
	private Dommage dommage;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONSTAT_ID")
	private Constat constat;

}
