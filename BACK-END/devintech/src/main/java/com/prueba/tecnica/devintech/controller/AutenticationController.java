package com.prueba.tecnica.devintech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.devintech.dto.ApiResponse;
import com.prueba.tecnica.devintech.dto.AuthenticationRequest;
import com.prueba.tecnica.devintech.dto.AuthenticationResponse;
import com.prueba.tecnica.devintech.dto.PermisosXRol;
import com.prueba.tecnica.devintech.entity.login;
import com.prueba.tecnica.devintech.repository.AutenticationRepository;
import com.prueba.tecnica.devintech.service.JwtService;
import com.prueba.tecnica.devintech.service.userService;
import com.prueba.tecnica.devintech.utils.ResponsEntityUtil;

@RestController
@RequestMapping("/authenticate")
public class AutenticationController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

	
	@Autowired
	userService autenticationService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired(required=true)
	AutenticationRepository autentication;
	
	
	
	
	@PostMapping(value = "/")
    public ResponseEntity<ApiResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            
            
        	login authenticatedUser = (login) autenticationService.authenticate(authenticationRequest);
            

            String jwtToken = jwtService.generateToken(authenticatedUser);
            List<PermisosXRol> permissions = autentication.permissionxrol(authenticationRequest.getUsername());

            return ResponsEntityUtil.responseApiOk("Autenticacion exitosa", new AuthenticationResponse(jwtToken,permissions,authenticatedUser.getUser_id()), true);
        }
        catch (BadCredentialsException e) {
        	return ResponsEntityUtil.responseApi401();
        }

        
    }
	

}
