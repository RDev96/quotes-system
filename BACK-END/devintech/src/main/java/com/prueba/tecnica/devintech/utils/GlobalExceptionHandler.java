package com.prueba.tecnica.devintech.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prueba.tecnica.devintech.dto.ApiResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleSecurityException(Exception exception) {
		ApiResponse errorDetail = null;

        // TODO send this stack trace to an observability tool
        exception.printStackTrace();

        if (exception instanceof BadCredentialsException) {

            return ResponsEntityUtil.responseApi403("The username or password is incorrect");

        }

        if (exception instanceof AccountStatusException) {

            return ResponsEntityUtil.responseApi403("The account is locked");
        }

        if (exception instanceof AccessDeniedException) {
           
            return ResponsEntityUtil.responseApi403("You are not authorized to access this resource");
            
        }

        if (exception instanceof SignatureException) {
            
            return ResponsEntityUtil.responseApi403("The JWT signature is invalid");
            
        }

        if (exception instanceof ExpiredJwtException) {
            
            return ResponsEntityUtil.responseApi403("The JWT token has expired");
        }

        if (errorDetail == null) {

            return ResponsEntityUtil.responseApi500();
            
        }
		return ResponsEntityUtil.responseApi401();
    }
	
	
}
