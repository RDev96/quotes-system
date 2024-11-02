package com.prueba.tecnica.devintech.dto;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class TransactionListDTO {
	
	private ArrayList<TransactionGetDTO> transactions;
	private boolean back;
	private boolean next;

}
