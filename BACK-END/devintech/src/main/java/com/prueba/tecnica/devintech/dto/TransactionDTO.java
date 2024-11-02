package com.prueba.tecnica.devintech.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Setter
@Getter
public class TransactionDTO {

	private Long user;
	private Long product;
	private String email;
	private String costs;
	private Double product_weight;
	private Double product_cost;
	private Double added_cost;
	private Double total;
	
}
