package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojo.Order;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order , Long>{
//	Order findById(String id);
//    List<Order> findAll();
//    @Transactional
//    void deleteById(String id);
}
