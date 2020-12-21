package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Customer;
import com.example.demo.service.PaymentService;

@RestController
public class PaymentController {
	
	private final PaymentService payS;
	private final static Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	public PaymentController(PaymentService payS) {
		this.payS = payS;
	}

	@PostMapping(value = "/paymentById", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> makePayment(@RequestBody Customer c, HttpServletRequest request){
		logger.info("In PaymentController - Make payment");
		return payS.makePayment(c);
	}
}
