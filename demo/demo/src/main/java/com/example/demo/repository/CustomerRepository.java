package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Customer;

public interface CustomerRepository extends CrudRepository<Customer , Long> {

	Customer findByName(String username);
	Customer findById(long id);
}