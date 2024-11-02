package com.prueba.tecnica.devintech.dto;

import java.util.List;

public class AuthenticationResponse {

	private final String jwt;
	private List<PermisosXRol> permissions;
	private Long user;

    public AuthenticationResponse(String jwt,List<PermisosXRol> permissions,Long user) {
        this.jwt = jwt;
        this.permissions = permissions;
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

	public List<PermisosXRol> getPermissions() {
		return permissions;
	}

	public Long getUser() {
		return user;
	}


	
    
    
	
}
