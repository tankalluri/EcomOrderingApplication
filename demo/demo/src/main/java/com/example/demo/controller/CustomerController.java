package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	private final CustomerService customerService;
	private final static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	 
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping(value = "/createCustomer", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> createOrder(@RequestBody Customer c, HttpServletRequest request){
		logger.info("In CustomerController - Create Customer");
		return customerService.createCustomer(c);
	}
}
