package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	
	 private final OrderService orderService;
	 private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping(value = "/createOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> createOrder(@RequestBody Order order, HttpServletRequest request){
		logger.info("In OrderController - Create Order");
		return orderService.createOrder(order);
	}
	
	@GetMapping(value = "/getOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> getOrder(@RequestBody Order order, HttpServletRequest request){ 
		logger.info("In OrderController - Get Order");
        	return orderService.getOrder(order);
	}
	
	@PutMapping(value = "/updateOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> updateOrder(@RequestBody Order order, HttpServletRequest request){ 
		logger.info("In OrderController - Update Order");
    	return orderService.updateOrder(order);
	}
    	
    @DeleteMapping(value = "/deleteOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> deleteOrder(@RequestBody Order order, HttpServletRequest request){ 
    	logger.info("In OrderController - Delete Order");
    	return orderService.deleteOrder(order);
    }
}
