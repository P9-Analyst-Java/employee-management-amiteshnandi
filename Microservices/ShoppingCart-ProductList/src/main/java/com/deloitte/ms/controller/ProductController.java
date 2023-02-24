package com.deloitte.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.Product;

import com.deloitte.ms.repo.ProductRepo;

@RestController
@RequestMapping("/productlist")
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<List<Product>>(productRepo.findAll(),HttpStatus.OK);}
	
	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		return new ResponseEntity<Product>(productRepo.getProductById(id),HttpStatus.OK);}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productRepo.save(product), HttpStatus.OK);
		
		
	}

}
