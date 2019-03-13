package com.shop.product.service;

import java.util.List;

import com.shop.product.domain.Product;

public interface ProductBusinessService {

	public List<Product> findAll();
	
	public Product save(Product product);
	
	public Product findById(Long id);
	
	public Product findByCode(String code);

}
