package com.capgemini.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	}
	
	

