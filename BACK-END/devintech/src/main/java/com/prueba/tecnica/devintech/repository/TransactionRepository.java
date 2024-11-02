package com.prueba.tecnica.devintech.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.devintech.entity.transactions;

@Repository
@Transactional
public interface TransactionRepository  extends JpaRepository<transactions, Long> {

	Page<transactions> findAll(Pageable pageable);
	
}
