package com.Eseurveys.model.entity;

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
@Table(name = "UNITE")
public class Unite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "MATRICULE", length = 1000)
	private String matricule;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_REMORQUE_ID")
	private TypeRemorque typeRemorque;

	@OneToMany(mappedBy = "unite", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Unite> unite;

}
