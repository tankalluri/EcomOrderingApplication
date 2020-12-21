package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Payment;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private final PaymentRepository payRepo;
	private final OrderRepository o;
	
	public PaymentService(PaymentRepository payRepo, OrderRepository o) {
		this.payRepo = payRepo;
		this.o = o;
	}

	public ResponseEntity<?> makePayment(Customer c) {
		Order oo = o.findById(c.getCust_id());
		
		Payment p = new Payment();	
		p.setTransaction_amount(oo.getSubtotal());
		p.setCust(c);
		payRepo.save(p);
		return null;
	}
}
