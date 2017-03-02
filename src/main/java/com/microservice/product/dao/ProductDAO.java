package com.microservice.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.product.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
	
}