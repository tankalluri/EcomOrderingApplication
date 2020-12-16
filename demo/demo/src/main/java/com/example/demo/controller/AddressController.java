package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Address;
import com.example.demo.service.AddressService;

@RestController
public class AddressController {
	private final AddressService addressService;
	 
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@PostMapping(value = "/createCustomerAddress", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> createOrder(@RequestBody Address a, HttpServletRequest request){
		return addressService.saveAddress(a);
	}
}
