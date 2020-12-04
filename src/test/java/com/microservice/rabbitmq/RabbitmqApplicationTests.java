package com.microservice.rabbitmq;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.microservice.rabbitmq.dto.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class ,webEnvironment = WebEnvironment.DEFINED_PORT)
public class RabbitmqApplicationTests {
	
	@Test
	public void test() {
		Order order = new Order();
		order.setName("Paneer pulao");
		order.setPrice(100.0);
		order.setQty(1);
		
		expect()
		 	.contentType(MediaType.APPLICATION_JSON_VALUE)
		 	.statusCode(200)
			.body(containsString("Success"))
	 	.given()
			.body(order)
			.contentType(MediaType.APPLICATION_JSON_VALUE)
		.when()
			.post("/order/c2")
		;
	}
}