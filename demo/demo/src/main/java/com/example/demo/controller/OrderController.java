package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/getOrders", produces = "application/json")
	public ResponseEntity<?> getOrder(HttpServletRequest request){ 
		logger.info("In OrderController - Get all orders");
		return orderService.getOrder();
	}
	
	@GetMapping(value = "/getOrderDetails", produces = "application/json")
	public String getOrderDetails(HttpServletRequest request){ 
		logger.info("In OrderController - Get order details");
		return "Success";
	}
	
	@GetMapping(value = "/getOrderById/{id}", produces = "application/json")
	public ResponseEntity<?> getOrderById(@PathVariable long id, HttpServletRequest request){ 
		logger.info("In OrderController - Get Order by Id");
        	return orderService.getOrderById(id);
	}
	
	@PutMapping(value = "/updateOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> updateOrder(@RequestBody Order order, HttpServletRequest request){ 
		logger.info("In OrderController - Update Order");
    	return orderService.updateOrder(order);
	}
    	
    @DeleteMapping(value = "/deleteOrder/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable("id") long id, HttpServletRequest request){ 
    	logger.info("In OrderController - Delete Order");
    	return orderService.deleteOrder(id);
    }
}
