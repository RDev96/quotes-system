package com.prueba.tecnica.devintech.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class product {
	
	@Id
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "product_name")
	private String product_name;
	
	@Basic(optional = false)
	@Column(name = "discount")
	private String discount;

}
