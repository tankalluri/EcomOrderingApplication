package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.pojo.Item;

public interface ItemRepository extends CrudRepository<Item , Long>{

}
