package com.prueba.tecnica.devintech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.devintech.dto.ApiResponse;
import com.prueba.tecnica.devintech.service.ProductService;
import com.prueba.tecnica.devintech.utils.ResponsEntityUtil;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
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
	@GetMapping(value = "/products",produces="application/json")
	public ResponseEntity<ApiResponse> getAll(Pageable pageable) {
		try {

			return productService.findAll(pageable);
			
		} catch (Exception e) {
			return ResponsEntityUtil.responseApi400(e.getLocalizedMessage(), "", false, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
