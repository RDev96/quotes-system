package com.prueba.tecnica.devintech.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "rol_permissions")
public class rol_permissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "rol_id")
	private Long rol_id;
	
	@Basic(optional = false)
	@Column(name = "permissions_id")
	private Long permissions_id;
	
	
}
