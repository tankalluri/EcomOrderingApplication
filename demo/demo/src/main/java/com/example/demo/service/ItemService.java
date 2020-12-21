package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepo;
	private final static Logger logger = LoggerFactory.getLogger(ItemService.class);
	 
	
	public ItemService(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

	public ResponseEntity<?> addProductItem(Item item) {
		ResponseMessage errorMessage = new ResponseMessage();
		
		if(this.checkItemInput(item).equals("success")) {
			Item i = new Item();
			i.setCost(item.getCost());
			i.setItemName(item.getItemName());
			i.setQty(item.getQty());
			itemRepo.save(i);
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
	
	public String checkItemInput(Item item) {
		if(item.getQty()!=0 && item.getCost()!=0 && item.getItemName()!=null)
			return "success";
		else
			return "failure";
	}
}
