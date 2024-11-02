package com.prueba.tecnica.devintech.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.tecnica.devintech.dto.ApiResponse;


public class ResponsEntityUtil {

	public static ResponseEntity<ApiResponse> responseApiOk(String message, Object data, Boolean success) {
		ApiResponse response = new ApiResponse();
		response.setData(data);
		response.setMessage(message);
		response.setSuccess(success);
		return ResponseEntity.ok().body(response);
	}

	public static ResponseEntity<ApiResponse> responseApi(String message, Object data, Boolean success,
			HttpStatus status) {
		ApiResponse response = new ApiResponse();
		response.setData(data);
		response.setMessage(message);
		response.setSuccess(success);
		return ResponseEntity.status(status).body(response);
	}

	public static ResponseEntity<ApiResponse> responseApi401() {
		ApiResponse response = new ApiResponse();
		response.setData(null);
		response.setMessage("Token no Valido");
		response.setSuccess(false);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}
	
	public static ResponseEntity<ApiResponse> responseApi403(String message) {
		ApiResponse response = new ApiResponse();
		response.setData(null);
		response.setMessage(message);
		response.setSuccess(false);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	}
	
	public static ResponseEntity<ApiResponse> responseApi500() {
		ApiResponse response = new ApiResponse();
		response.setData(null);
		response.setMessage("Error");
		response.setSuccess(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	
	public static ResponseEntity<ApiResponse> responseApi400(String message, Object data, Boolean success,
			HttpStatus status) {
		ApiResponse response = new ApiResponse();
		response.setData(data);
		response.setMessage(message);
		response.setSuccess(false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
