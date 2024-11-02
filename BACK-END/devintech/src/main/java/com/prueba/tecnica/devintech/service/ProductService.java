package com.prueba.tecnica.devintech.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.devintech.dto.ApiResponse;
import com.prueba.tecnica.devintech.dto.ResponseProductDTO;
import com.prueba.tecnica.devintech.entity.product;
import com.prueba.tecnica.devintech.repository.ProductsRepository;
import com.prueba.tecnica.devintech.utils.ResponsEntityUtil;

@Service
public class ProductService {

	@Autowired
	ProductsRepository productsRepository;
	
	
	public ResponseEntity<ApiResponse> findAll(Pageable pageable) {

		try {
			ResponseProductDTO response = new ResponseProductDTO();
			ArrayList<product> entitiPage = (ArrayList<product>) productsRepository.findAll();
			response.setProducts(entitiPage);
			return ResponsEntityUtil.responseApiOk("Resultado lista productos", response, true);

		} catch (Exception e) {

			return ResponsEntityUtil.responseApi400(e.getMessage(), null, false, HttpStatus.BAD_REQUEST);
		}

	}
	
	
}
