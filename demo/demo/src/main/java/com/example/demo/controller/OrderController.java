package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	
	 private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping(value = "/createOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> createOrder(@RequestBody Order order, HttpServletRequest request){
		return orderService.createOrder(order);
	}
	
	@GetMapping(value = "/getOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> getOrder(@RequestBody Order order, HttpServletRequest request){ 
        	return orderService.getOrder(order);
	}
	
	@PutMapping(value = "/updateOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> updateOrder(@RequestBody Order order, HttpServletRequest request){ 
    	return orderService.updateOrder(order);
	}
    	
    @DeleteMapping(value = "/deleteOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> deleteOrder(@RequestBody Order order, HttpServletRequest request){ 
    	return orderService.deleteOrder(order);
    }
}
