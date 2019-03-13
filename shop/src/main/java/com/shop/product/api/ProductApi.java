package com.shop.product.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.product.domain.Product;
import com.shop.product.service.ProductBusinessService;

@RequestMapping(value = "/productapi")
@ResponseBody
@Controller
public class ProductApi {

	@Autowired
	private ProductBusinessService businessService;

	@RequestMapping(value = "/products", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> viewList = businessService.findAll();
		return new ResponseEntity<List<Product>>(viewList, viewList != null && !CollectionUtils.isEmpty(viewList) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@RequestMapping(
			value = "/save",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Product> save(@RequestBody Product product) {
		Product result = businessService.save(product);
		return new ResponseEntity<Product>(result, result != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(
			value = "/findByCode",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Product> findByCode(@RequestBody String code) {
		Product result = businessService.findByCode(code);
		return new ResponseEntity<Product>(result, result != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
