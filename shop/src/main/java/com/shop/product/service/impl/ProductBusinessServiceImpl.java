package com.shop.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.product.dao.ProductDAO;
import com.shop.product.domain.Product;
import com.shop.product.service.ProductBusinessService;

@Service
public class ProductBusinessServiceImpl implements ProductBusinessService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		List<Product> resultList = (List<Product>) productDAO.findAll();
		return resultList;
	}

	@Override
	public Product save(Product product) {
		Product resultProduct = productDAO.save(product);
		return resultProduct;
	}

	@Override
	public Product findById(Long id) {
		Optional<Product> result = productDAO.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return new Product();
	}

	@Override
	public Product findByCode(String code) {
		Product product = productDAO.findByCode(code);
		return product;
	}

}