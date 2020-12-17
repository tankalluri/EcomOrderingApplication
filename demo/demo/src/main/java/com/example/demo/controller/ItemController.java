package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
	
	private final ItemService itemService; 
	private final static Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping(value = "/addItem", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> addProductItem(@RequestBody Item item, HttpServletRequest request){
		logger.info("In ItemController - Add Item");
		return itemService.addProductItem(item);
	}
}
