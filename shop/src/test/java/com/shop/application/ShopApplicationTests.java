package com.shop.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shop.products.test.unit.AllTestsForProduct;
import com.shop.products.test.unit.ProductCompareTest;
import com.shop.products.test.unit.ProductTest;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

	@Test
	public void contextLoads() {
	}

}
