package com.rest1.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class OrderHistory {
	@Id @GeneratedValue
	private int serialNo;
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="productId")
	private Products products;
	
	public OrderHistory(int serialNo, int quantity, Products products, Orders orders) {
		super();
		this.serialNo = serialNo;
		this.quantity = quantity;
		this.products = products;
		this.orders = orders;
	}
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="orderId")
	private Orders orders;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	
	
	public OrderHistory() {
		
	}
}
