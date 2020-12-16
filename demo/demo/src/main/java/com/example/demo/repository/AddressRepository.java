package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Address;

public interface AddressRepository extends CrudRepository<Address , Long>{

}
