package com.deloitte.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cart")
@Data
public class Cart {
	
	@Id
	@Column(name="cartid")
	private int cartId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pdtid")
	private int pdtid;
	
	@Column(name="quantity")
	private int quantity;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPdtid() {
		return pdtid;
	}

	public void setPdtid(int pdtid) {
		this.pdtid = pdtid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
