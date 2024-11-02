package com.prueba.tecnica.devintech.entity;

import java.util.Date;

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
@Table(name = "transactions")
public class transactions {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Column(name = "user_id")
	private Long user_id;
	
	@Basic(optional = false)
	@Column(name = "product_id")
	private Long product_id;
	
	@Basic(optional = false)
	@Column(name = "email")
	private String email;
	
	@Basic(optional = false)
	@Column(name = "additional_costs")
	private String additional_costs;
	
	@Basic(optional = false)
	@Column(name = "product_weight")
	private Double product_weight;
	
	@Basic(optional = false)
	@Column(name = "product_cost")
	private Double product_cost;
	
	@Basic(optional = false)
	@Column(name = "added_cost")
	private Double added_cost;
	
	@Basic(optional = false)
	@Column(name = "creation_date")
	private Date creation_date;
	
	@Basic(optional = false)
	@Column(name = "total")
	private Double total;
	

}
