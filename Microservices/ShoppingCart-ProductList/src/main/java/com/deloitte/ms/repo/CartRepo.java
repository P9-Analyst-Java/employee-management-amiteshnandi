package com.deloitte.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, String> {
	
	@Query(value="Select * from cart where username= :username", nativeQuery = true)
	public List<Cart> getCartItemsByUsername(String username);
	
	@Query(value="Select * from cart where pdtid= :pdtid", nativeQuery = true)
	public List<Cart >getCartItemsByPdtId(int pdtid);
		
	
	
	
	
}
