package com.microservice.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.microservice.rabbitmq.constants.Status;
import com.microservice.rabbitmq.dto.Order;
import com.microservice.rabbitmq.dto.OrderStatus;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

	@Value("${rabbitmq.queue.name}")
	private String queueName;

	@Value("${rabbitmq.queue.exchange}")
	private String exchange;

	@Value("${rabbitmq.queue.routing.key}")
	private String routingKey;

	@Autowired
	private RabbitTemplate template;

	@PostMapping(value = "/{restaurantName}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
		order.setOrderId(UUID.randomUUID().toString());
		// restaurantservice
		// payment service
		OrderStatus orderStatus = new OrderStatus(order, Status.IN_PROGRESS,
				"order placed succesfully in " + restaurantName);
		template.convertAndSend(exchange, routingKey, orderStatus);
		return new ResponseEntity<>("Success !!", HttpStatus.OK);

	}
}
