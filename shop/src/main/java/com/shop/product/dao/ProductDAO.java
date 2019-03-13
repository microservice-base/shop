package com.shop.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.product.domain.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {

	Product findByCode(String code);

}