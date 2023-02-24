package com.deloitte.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deloitte.ms.entity.Product;


public interface ProductRepo extends JpaRepository<Product, String>{
	 
	@Query(value="Select * from product where productid= :id", nativeQuery=true)
	public Product getProductById(int id);
}
