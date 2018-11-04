package com.shop.products.models;

public class Product implements Comparable<Product> {

	private String name;

	public Product() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Product product) {
		// String karşılaştırma yapıldığında result karakter sayılarını dönüyor
		int result = this.getName().compareTo(product.getName()); 

		if (result > 0) {
			return 1;
		} else if (result == 0) {
			return 0;
		} else {
			return -1;
		}
	}

}
