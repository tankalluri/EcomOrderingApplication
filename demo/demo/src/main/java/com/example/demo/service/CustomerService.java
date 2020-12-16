package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Address;
import com.example.demo.pojo.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository custRepository;
	private final AddressRepository addRepo;

    public CustomerService(CustomerRepository customerRepository, AddressRepository addRepo) {
        this.custRepository = customerRepository;
        this.addRepo = addRepo;
    }

	public ResponseEntity<?> createCustomer(Customer c) {
		ResponseMessage errorMessage = new ResponseMessage();
		Customer cc = new Customer();
		Address addCust = new Address();
		cc.setName(c.getName());
		cc.setAddress(c.getAddress());
		addCust.setCity(cc.getAddress().getCity());
		addCust.setLine1(cc.getAddress().getLine1());
		addCust.setState(cc.getAddress().getState());
		addCust.setType(cc.getAddress().getType());
		addCust.setZip(cc.getAddress().getZip());

        Customer userByUsername = this.findByUserName(c.getName());
        if (userByUsername != null) {
            errorMessage.setMessage("Username already exists!");
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }
        custRepository.save(cc);
        addRepo.save(addCust);
        errorMessage.setMessage("User registered successfully.");
        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
	}
	
	public Customer findByUserName(String username) {
        return custRepository.findByName(username);
    }

}
