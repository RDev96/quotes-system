package com.prueba.tecnica.devintech.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.devintech.entity.product;

@Repository
@Transactional
public interface ProductsRepository extends JpaRepository<product, Long> {
	
	
	Page<product> findAll(Pageable pageable);

}
