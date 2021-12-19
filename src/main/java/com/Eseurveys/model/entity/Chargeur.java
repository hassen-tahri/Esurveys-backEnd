package com.Eseurveys.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//cette classe designe le client
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CHARGEUR")
public class Chargeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "INTITULE", length = 1000)
	private String intitule;

	@Column(name = "PAYS", length = 1000)
	private String pays;

	@Column(name = "EMAIL", length = 1000)
	private String email;

	@Column(name = "NUM_TEL", length = 1000)
	private String numTel;

	@Column(name = "ADRESSE", length = 1000)
	private String adresse;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UTILISATEUR_ID")
	private User user;

}
