package com.prueba.tecnica.devintech.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class users {

	@Id
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@Column(name = "lastname")
	private String lastname;

	@Basic(optional = false)
	@Column(name = "email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "rol", nullable = false)
	private rol rol;

}
