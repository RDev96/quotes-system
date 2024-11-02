package com.prueba.tecnica.devintech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.devintech.dto.ApiResponse;
import com.prueba.tecnica.devintech.dto.AuthenticationRequest;
import com.prueba.tecnica.devintech.dto.PermisosXRol;
import com.prueba.tecnica.devintech.entity.login;
import com.prueba.tecnica.devintech.repository.AutenticationRepository;
import com.prueba.tecnica.devintech.utils.ResponsEntityUtil;

@Service
public class userService {

	@Autowired(required=true)
	AutenticationRepository autentication;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private AuthenticationManager authenticationManager;

	public static List<PermisosXRol> findAll(String usuario) {

		try {
			//List<PermisosXRol> entitiPage = autentication.permissionxrol(usuario);
			return null;

		} catch (Exception e) {

			return null;
		}

	}

	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return autentication.findByUsername(username);
	}
	
	
	public UserDetails authenticate(AuthenticationRequest input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return autentication.findByUsername(input.getUsername());
    }

}
