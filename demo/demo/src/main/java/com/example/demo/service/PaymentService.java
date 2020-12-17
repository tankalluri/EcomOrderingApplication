package com.example.demo.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Customer;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Payment;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {
	
	private final CustomerRepository customerRepo;
	private final PaymentRepository payRepo;
	
	public PaymentService(CustomerRepository customerRepo, PaymentRepository payRepo) {
		this.customerRepo = customerRepo;
		this.payRepo = payRepo;
	}

	public ResponseEntity<?> makePayment(long id) {
		int sum = 0;
		Payment p = new Payment();
		p.setDate(java.time.LocalDate.now());
		Customer c = customerRepo.findById(id);
		Set<Order> ord = c.getOrder();
		for(Order o : ord) {
			sum += o.getTotal();
		}
		p.setTransaction_amount(sum);
		p.setCust(c);
		payRepo.save(p);
		return null;
	}
}
