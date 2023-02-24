package com.deloitte.ms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/get")
public class AuthController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/productt")
	public List<Object> getProduct() {
	String url="http://localhost:3003/productlist/getAllProducts";
	Object object= restTemplate.getForObject(url, Object.class);
	return Arrays.asList(object);
	}
	
	@GetMapping("/cartlist/{username}")
	public List<Object> getCart(@PathVariable String username) {
	String url="http://localhost:3003/cart/"+username;
	Object object= restTemplate.getForObject(url, Object.class);
	return Arrays.asList(object);
	}
	

	@RequestMapping(value="/addtocart/{customername}/{id}", method = {RequestMethod.POST})
	public List<Object> addToCart(@PathVariable String customername,@PathVariable Integer id) {
	String url="http://localhost:3003/cart/addCartItems/"+customername+"/"+id;
	Object object= restTemplate.getForObject(url, Object.class);
	return Arrays.asList(object);
	}






	

}
