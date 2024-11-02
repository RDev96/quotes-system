package com.prueba.tecnica.devintech.entity;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.prueba.tecnica.devintech.dto.PermisosXRol;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "permissions")
public class permissions {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "screen_name")
	private String screen_name;
	
	@Basic(optional = false)
	@Column(name = "url")
	private String url;
	

	
}
