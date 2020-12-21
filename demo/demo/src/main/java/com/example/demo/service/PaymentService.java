package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Payment;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private final static Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	private final PaymentRepository payRepo;
	private final OrderRepository o;
	private final CustomerRepository custrepo;
	
	public PaymentService(CustomerRepository custrepo, PaymentRepository payRepo, OrderRepository o) {
		this.payRepo = payRepo;
		this.o = o;
		this.custrepo = custrepo;
	}

	public ResponseEntity<?> makePayment(Customer c) {
		ResponseMessage errorMessage = new ResponseMessage();
		Customer customer = custrepo.findByName(c.getName());
		long id = customer.getCust_id();
		
		Order orders = o.findById(1);
		Payment p = new Payment();	
		p.setTransaction_amount(orders.getSubtotal());
		p.setCust(customer);
		payRepo.save(p);
		errorMessage.setMessage("Payment done successfully.");
		logger.info("Payment done successfully.");
        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}
}
