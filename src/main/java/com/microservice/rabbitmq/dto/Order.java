package com.microservice.rabbitmq.dto;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -1519997205245293914L;
	private String orderId;
	private String name;
	private int qty;
	private double price;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}

}
