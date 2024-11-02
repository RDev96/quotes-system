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
@Table(name = "rol")
public class rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "rol_name")
	private String rol_name;
	
	@Basic(optional = false)
	@Column(name = "status")
	private Boolean status;

    @OneToMany(mappedBy = "rol")
    private Set<users> users;
	
}
