package com.shop.products.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.shop.products.models.Product;

public class ProductService {
	
	private List<Product> productList = new ArrayList<Product>();
	
	public int productSize() {
		return productList.size();
	}

	public void productAdd(Product product) {
		productList.add(product);
	}

	public List<Product> getSortedProductList() {
		Collections.sort(productList);
		return productList;
	}

}
