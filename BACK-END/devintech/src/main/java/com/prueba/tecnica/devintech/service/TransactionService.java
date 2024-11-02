package com.prueba.tecnica.devintech.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.devintech.dto.ApiResponse;
import com.prueba.tecnica.devintech.dto.TransactionDTO;
import com.prueba.tecnica.devintech.dto.TransactionGetDTO;
import com.prueba.tecnica.devintech.dto.TransactionListDTO;
import com.prueba.tecnica.devintech.entity.product;
import com.prueba.tecnica.devintech.entity.transactions;
import com.prueba.tecnica.devintech.repository.ProductsRepository;
import com.prueba.tecnica.devintech.repository.TransactionRepository;
import com.prueba.tecnica.devintech.utils.ResponsEntityUtil;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	ProductsRepository productsRepository;
	
	
	public ResponseEntity<ApiResponse> findAll(Pageable pageable) {

		try {
			Sort sort = Sort.by(Sort.Direction.DESC, "id");
			Page<transactions> entitiPage = transactionRepository
					.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort));
			List<transactions> lista = (List<transactions>) entitiPage.getContent();
			List<product> products = productsRepository.findAll();
			
			 boolean back = entitiPage.hasPrevious(); // Si es la primera página
		     boolean next = entitiPage.hasNext();
			
			Long size = transactionRepository.count();
			lista.size();
			return ResponsEntityUtil.responseApiOk("Resultado lista usuarios", responseList(lista,products,back,next), true);

		} catch (Exception e) {

			return ResponsEntityUtil.responseApi400(e.getMessage(), null, false, HttpStatus.BAD_REQUEST);
		}

	}
	
	
	public ResponseEntity<ApiResponse> saveTransaction(TransactionDTO request){
		try {
			
			ArrayList<transactions> transactionList = buildArray(request);
			transactionRepository.saveAll(transactionList);
			
			return ResponsEntityUtil.responseApiOk("Resultado exitoso", null, true);

		} catch (Exception e) {

			return ResponsEntityUtil.responseApi400(e.getMessage(), null, false, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ArrayList<transactions> buildArray(TransactionDTO request){
		ArrayList<transactions> transactions = new ArrayList();
		transactions transaction = new transactions();
		
		transaction.setAdded_cost((request.getAdded_cost() != null) ? request.getAdded_cost():Double.valueOf(0));
		transaction.setAdditional_costs((request.getCosts() != null) ? request.getCosts():"");
		transaction.setEmail((request.getEmail() != null) ? request.getEmail():"");
		transaction.setProduct_cost((request.getProduct_cost() != null) ? request.getProduct_cost():Double.valueOf(0));
		transaction.setProduct_id((request.getProduct() != null) ? request.getProduct():0L);
		transaction.setProduct_weight((request.getProduct_weight() != null) ? request.getProduct_weight():Double.valueOf(0));
		transaction.setTotal((request.getTotal() != null) ? request.getTotal():Double.valueOf(0));
		transaction.setUser_id((request.getUser() != null) ? request.getUser():0L);
		transaction.setCreation_date(new Date());
		
		transactions.add(transaction);
		return transactions;
		
	}
	
	public TransactionListDTO responseList(List<transactions> transactions,List<product> products,boolean back,boolean next){
		TransactionListDTO response = new TransactionListDTO();
		ArrayList<TransactionGetDTO> list = new ArrayList();
		
		for (transactions transaction : transactions) {
			
			Optional<product> productItem = products.stream().filter(prod -> prod.getId() == transaction.getProduct_id()).findFirst();
			TransactionGetDTO transactionGetDTO = new TransactionGetDTO(
					transaction.getEmail(), 
					productItem.get().getProduct_name(), 
					transaction.getProduct_weight(), 
					transaction.getProduct_cost(), 
					transaction.getAdded_cost(), 
					transaction.getTotal(), 
					transaction.getCreation_date()+"");
			list.add(transactionGetDTO);
		}
		
		response.setTransactions(list);
		response.setBack(back);
		response.setNext(next);
		return response;
	}
	

}
