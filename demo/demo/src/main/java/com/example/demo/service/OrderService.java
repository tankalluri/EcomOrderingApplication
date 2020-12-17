package com.example.demo.service;

import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
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

	public ResponseEntity<?> getOrderById(long id) {
		 ResponseMessage responseMessage = new ResponseMessage();
	        Order order = this.getOrderBy(id);
	        if (order == null) {
	            responseMessage.setMessage("Order with id " + id + " not found");
	            logger.warn("Order with id " + id + " not found");
	            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	 public Order getOrderBy(long id) {
	        return orderRepo.findById(id);
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
			o.setOrder_id(order.getOrder_id());
			HashSet<Item> items = (HashSet<Item>) order.getItem();
			orderRepo.save(o);
			for(Item item : items) {
				itemRepo.save(item);
			}
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
		ResponseMessage responseMessage = new ResponseMessage();
        Order currentOrder = this.getOrderBy(order.getOrder_id());
        if (currentOrder != null) {
            if (order.getStatus() == null || order.getSubtotal() == 0 ||
            		order.getTotal() == 0 || order.getTax() <= 0) {
                responseMessage.setMessage("Invalid details or an invalid Json format.");
                logger.info("Invalid details or Invalid JSON.");
                return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
            }
            currentOrder.setStatus(order.getStatus());
            currentOrder.setItem(order.getItem());
            currentOrder.setTotal(order.getTotal());
            currentOrder.setSubtotal(order.getSubtotal());
            currentOrder.setTax(order.getTax());
            currentOrder.setShipping_charges(order.getShipping_charges());
            orderRepo.save(currentOrder);
            
            HashSet<Item> items = (HashSet<Item>) order.getItem();
			for(Item item : items) {
				itemRepo.save(item);
			}
			
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            responseMessage.setMessage("Order with id " + order.getOrder_id() + " not found");
            logger.info("Book with id " + order.getOrder_id() + " not found");
            return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
        }
	}

	public ResponseEntity<?> deleteOrder(long id) {
		ResponseMessage responseMessage = new ResponseMessage();
        Order order = this.getOrderBy(id);
        if (order != null) {
            orderRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
        	logger.info("Order with id " + id + " not found");
            responseMessage.setMessage("Order with id " + id + " not found");
        }
        return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> getOrder() {
		ResponseMessage responseMessage = new ResponseMessage();
        List<Order> order;
        order = orderRepo.findAll();
        if (order == null) {
            responseMessage.setMessage("No orders found");
            logger.warn("No orders found");
            return new ResponseEntity<>(responseMessage, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
	}
}
