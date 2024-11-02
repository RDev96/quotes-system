package com.prueba.tecnica.devintech.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ApiResponse {

	private Boolean success;
	private String message;
	private Object data;

	public ApiResponse() {
		super();
	}
	
	

	public ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public ApiResponse(Boolean success) {
		this.success = success;
	}

	public ApiResponse(String message) {
		this.message = message;
	}



	public ApiResponse(Boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	

}
