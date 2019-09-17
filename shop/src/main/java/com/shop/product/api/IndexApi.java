package com.shop.product.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "/")
@ResponseBody
@Controller
public class IndexApi {

    @RequestMapping(value = "/", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		
    	String val = "Shop Application is running...";
    	
		return new ResponseEntity<String>(val, val != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
    
}

