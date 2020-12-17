package com.example.demo.service;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.controller.CustomerController;
import com.example.demo.pojo.Item;
import com.example.demo.pojo.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepo;
	private final ItemRepository itemRepo;
	private final static Logger logger = LoggerFactory.getLogger(OrderService.class);
	 
	
	public OrderService(OrderRepository orderRepo, ItemRepository itemRepo) {
        this.orderRepo = orderRepo;
        this.itemRepo = itemRepo;
    }

	public ResponseEntity<?> getOrder(Order order) {
		return null;
	}

	public ResponseEntity<?> createOrder(Order order) {
		ResponseMessage errorMessage = new ResponseMessage();
		
		if(this.checkOrderInput(order).equals("success")) {
			Order o = new Order();
			Item i = new Item();
			o.setStatus(order.getStatus());
			o.setTotal(order.getTotal());
			o.setSubtotal(order.getSubtotal());
			o.setTax(order.getTax());
			o.setShipping_charges(order.getShipping_charges());
			o.setSubtotal(order.getSubtotal());
			o.setItem(order.getItem());
			o.setCust(order.getCust());
			o.setOrder_id(order.getOrder_id());
//			HashSet<Item> items = (HashSet<Item>) order.getItem();
//			for(Item item : items) {
//				i.setCost(item.getCost());
//				i.setItemName(item.getItemName());
//				i.setOrder(o);
//				i.setQty(item.getQty());
//				itemRepo.save(i);
//			}
			orderRepo.save(o);
			errorMessage.setMessage("Item added successfully.");
			logger.info("Item added successfully.");
	        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
		}
		else {
			errorMessage.setMessage("Unable to add item!");
			logger.error("Unable to add item!");
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
		}
	}
	
	public String checkOrderInput(Order order) {
		return "success";
	}

	public ResponseEntity<?> updateOrder(Order order) {
		return null;
	}

	public ResponseEntity<?> deleteOrder(Order order) {
		return null;
	}
}
