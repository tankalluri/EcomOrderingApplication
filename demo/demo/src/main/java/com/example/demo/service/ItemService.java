package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepo;
	
	public ItemService(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

	public ResponseEntity<?> addProductItem(Item item) {
		ResponseMessage errorMessage = new ResponseMessage();
		
		if(this.checkItemInput(item).equals("success")) {
			Item i = new Item();
			i.setCost(item.getCost());
			i.setName(item.getName());
			i.setQty(item.getQty());
			itemRepo.save(i);
			errorMessage.setMessage("Item added successfully.");
	        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
		}
		else {
			errorMessage.setMessage("Unable to add item!");
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
		}
	}
	
	public String checkItemInput(Item item) {
		if(item.getQty()!=0 && item.getCost()!=0 && item.getName()!=null)
			return "success";
		else
			return "failure";
	}
}
