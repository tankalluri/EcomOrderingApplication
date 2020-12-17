package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepo;
	private final ItemRepository itemRepo;
	
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
			o.setStatus(order.getStatus());
			o.setTotal(order.getTotal());
			o.setSubtotal(order.getSubtotal());
			o.setTax(order.getTax());
			o.setShipping_charges(order.getShipping_charges());
			o.setSubtotal(order.getSubtotal());
			o.setItem(order.getItem());
			o.setCust(order.getCust());
			order.getItem();
			orderRepo.save(o);
			
			
			//itemRepo.save();
			errorMessage.setMessage("Item added successfully.");
	        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
		}
		else {
			errorMessage.setMessage("Unable to add item!");
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
