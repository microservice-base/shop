package com.shop.products;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.shop.products.models.Product;

public class ProductCompareTest {

	private Product p1 = null;
	private Product p2 = null;

	@Before
	public void setUp() {
		p1 = new Product();
		p1.setName("ceket");

		p2 = new Product();
		p2.setName("pantolon");
	}

	@Test
	public void t01_compare_after() {
		assertEquals("ceket alfabetik olarak pantolon dan önde olması gerekiyor", -1  , p1.compareTo(p2));
	}

	@Test
	public void t02_compare_same() {
		assertEquals("ceket ile karşılaştırılan aynıdır", 0, p1.compareTo(p1));
	}

	@Test
	public void t03_compare_before() {
		assertEquals("pantolon alfabetik olarak ceket dan sonra gelmesi gerekiyor", 1 , p2.compareTo(p1));
	}

}
