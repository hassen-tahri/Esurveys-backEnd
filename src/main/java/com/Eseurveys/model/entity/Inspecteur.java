package com.Eseurveys.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//cette classe designe l'agent
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INSPECTEUR")
public class Inspecteur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOM", length = 1000)
	private String nom;

	@Column(name = "PRENOM", length = 1000)
	private String prenom;

	@Column(name = "EMAIL", length = 1000)
	private String email;

	@Column(name = "NUM_TEL", length = 1000)
	private String numTel;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UTILISATEUR_ID")
	private User user;

}
