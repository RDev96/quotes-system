package com.prueba.tecnica.devintech.dto;

import java.util.ArrayList;

import com.prueba.tecnica.devintech.entity.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseProductDTO {
	
	private ArrayList<product> products;

}
