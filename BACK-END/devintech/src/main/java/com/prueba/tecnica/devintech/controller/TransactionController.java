package com.prueba.tecnica.devintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.devintech.dto.ApiResponse;
import com.prueba.tecnica.devintech.dto.TransactionDTO;
import com.prueba.tecnica.devintech.service.TransactionService;
import com.prueba.tecnica.devintech.service.userService;
import com.prueba.tecnica.devintech.utils.ResponsEntityUtil;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	userService userService;
	
	
	@ApiResponses(value = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = {
						@Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = ApiResponse.class)
						) 
					}
			
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
		}
	)
	@PostMapping(value = "/add",produces="application/json")
	public ResponseEntity<ApiResponse> save(@RequestBody TransactionDTO request) {
		try {

			return transactionService.saveTransaction(request);
			
		} catch (Exception e) {
			return ResponsEntityUtil.responseApi400(e.getLocalizedMessage(), "", false, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	@ApiResponses(value = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = {
						@Content(
								mediaType = "application/json", 
								schema = @Schema(implementation = ApiResponse.class)
						) 
					}
			
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
			@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
					@Content(
							mediaType = "application/json", 
							schema = @Schema(implementation = ApiResponse.class)
					) 
				}
		
			),
		}
	)
	@GetMapping(value = "/getAll",produces="application/json")
	public ResponseEntity<ApiResponse> getAll(Pageable pageable) {
		try {

			return transactionService.findAll(pageable);
			
		} catch (Exception e) {
			return ResponsEntityUtil.responseApi400(e.getLocalizedMessage(), "", false, HttpStatus.BAD_REQUEST);
		}
	}
	

	

}
