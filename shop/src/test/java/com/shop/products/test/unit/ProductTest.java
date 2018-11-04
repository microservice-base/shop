package com.shop.products.test.unit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.shop.products.models.Product;
import com.shop.products.services.ProductService;

public class ProductTest {

	ProductService productService = null;
	Product product1 = null;
	Product product2 = null;

	@Before
	public void setUp() {
		productService = new ProductService();
		product1 = new Product();
		product2 = new Product();
	}

	@Test
	public void t01_zeroSizeList() {
		assertEquals("listenin buyuklugu 0 degildir", 0, productService.productSize());
	}

	@Test
	public void t02_whenAddOneProduct_thenProductSize() {
		productService.productAdd(product1);
		assertEquals("listenin buyguklugu 1 degildir", 1, productService.productSize());
	}

	@Test
	public void t03_whenAddTwoProducts_thenProductSize() {
		productService.productAdd(product1);
		productService.productAdd(product2);

		assertEquals("listenin buyuklugu 2 degildir", 2, productService.productSize());
	}

	@Test
	public void t04_whenDoNothing_thenReturnSortedProductList() {
		List<Product> list = productService.getSortedProductList();
		assertEquals("liste bos degil", 0, list.size());
	}

	@Test
	public void t04_whenAddOneProduct_thenReturnSortedProductList() {
		productService.productAdd(product1);
		product1.setName("pantolon");
		List<Product> list = productService.getSortedProductList();
		assertEquals("listenin ilk elemanı pantolon degildir", "pantolon", list.get(0).getName());
	}

	@Test
	public void t05_whenAddTwoProducts_thenReturnSortedProductList() {
		productService.productAdd(product1);
		product1.setName("pantolon");

		productService.productAdd(product2);
		product2.setName("ceket");

		List<Product> list = productService.getSortedProductList();

		assertEquals("listenin ilk elemanı ceket degildir", "ceket", list.get(0).getName());

		assertEquals("listenin ikinci elemanı pantolon degildir", "pantolon", list.get(1).getName());
	}

}
