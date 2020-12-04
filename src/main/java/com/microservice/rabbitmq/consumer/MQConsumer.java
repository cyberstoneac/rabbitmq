package com.microservice.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.microservice.rabbitmq.dto.OrderStatus;

@Component
public class MQConsumer {
	
	@RabbitListener(queues = "my_queue")
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue : " + orderStatus);
    }
	
}
