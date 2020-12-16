package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository custRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.custRepository = customerRepository;
    }

	public ResponseEntity<?> createCustomer(Customer c) {
		ResponseMessage errorMessage = new ResponseMessage();
		Customer cc = new Customer();
		cc.setName(c.getName());

        Customer userByUsername = this.findByUserName(c.getName());
        if (userByUsername != null) {
            errorMessage.setMessage("Username already exists!");
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }
        custRepository.save(cc);
        errorMessage.setMessage("User registered successfully.");
        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}
	
	public Customer findByUserName(String username) {
        return custRepository.findByName(username);
    }

}
