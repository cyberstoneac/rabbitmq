package com.microservice.rabbitmq.dto;

import java.io.Serializable;

import com.microservice.rabbitmq.constants.Status;

public class OrderStatus implements Serializable {

	private static final long serialVersionUID = -4779275608061692249L;
	private Order order;
	private Status status;// progress,completed
	private String message;
	
	public OrderStatus() {
		super();
	}

	public OrderStatus(Order order, Status status, String message) {
		super();
		this.order = order;
		this.status = status;
		this.message = message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OrderStatus [order=" + order + ", status=" + status + ", message=" + message + "]";
	}

}