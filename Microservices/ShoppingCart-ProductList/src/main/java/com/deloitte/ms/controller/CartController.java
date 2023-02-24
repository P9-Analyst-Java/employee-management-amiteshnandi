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

import com.deloitte.ms.entity.Cart;
import com.deloitte.ms.entity.Product;
import com.deloitte.ms.repo.CartRepo;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartRepo cartRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Cart>> getCart(){
		return new ResponseEntity<List<Cart>>(cartRepo.findAll(),HttpStatus.OK);}
	
	@GetMapping("/{username}")
	public ResponseEntity<List<Cart>> getCartByName(@PathVariable String username){
		return new ResponseEntity<List<Cart>>(cartRepo.getCartItemsByUsername(username),HttpStatus.OK);}
	
	@GetMapping("/{productid}")
	public ResponseEntity<List<Cart>> getCartById(@PathVariable int pdtid){
		return new ResponseEntity<List<Cart>>(cartRepo.getCartItemsByPdtId(pdtid),HttpStatus.OK);}
	
	
	@PostMapping("/addCartItems")
	public ResponseEntity<Cart> addCartItems(@RequestBody Cart cart){
		return new ResponseEntity<Cart>(cartRepo.save(cart), HttpStatus.OK);}
}
