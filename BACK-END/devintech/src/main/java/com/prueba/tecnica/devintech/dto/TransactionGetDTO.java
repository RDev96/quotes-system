package com.prueba.tecnica.devintech.dto;

import java.util.Date;

public class TransactionGetDTO {
	
	
	private String user;
	private String product;
	private Double product_weight;
	private Double product_cost;
	private Double added_cost;
	private Double total;
	private String creation_date;
	
	
	
	
	public TransactionGetDTO(String user, String product, Double product_weight, Double product_cost, Double added_cost,
			Double total, String creation_date) {
		super();
		this.user = user;
		this.product = product;
		this.product_weight = product_weight;
		this.product_cost = product_cost;
		this.added_cost = added_cost;
		this.total = total;
		this.creation_date = creation_date;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(Double product_weight) {
		this.product_weight = product_weight;
	}
	public Double getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(Double product_cost) {
		this.product_cost = product_cost;
	}
	public Double getAdded_cost() {
		return added_cost;
	}
	public void setAdded_cost(Double added_cost) {
		this.added_cost = added_cost;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	
	
	

}
