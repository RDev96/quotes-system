package com.prueba.tecnica.devintech.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AuthenticationRequest {

	private String username;
	private String password;

}
