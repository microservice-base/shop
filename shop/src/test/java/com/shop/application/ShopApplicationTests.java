package com.shop.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.products.AllTestsForProduct;
import com.shop.products.ProductCompareTest;
import com.shop.products.ProductTest;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

	@Test
	public void contextLoads() {
	}

}
