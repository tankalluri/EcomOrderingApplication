package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojo.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order , Long>{
	Order findById(long id);
    List<Order> findAll();
    @Transactional
    void deleteById(long id);
}
