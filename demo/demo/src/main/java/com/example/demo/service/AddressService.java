package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Util.ResponseMessage;
import com.example.demo.pojo.Address;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressService {
	
	private final AddressRepository addressRepo;
	
	public AddressService(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

	public ResponseEntity<?> saveAddress(Address a) {
		ResponseMessage errorMessage = new ResponseMessage();
		Address add = new Address();
		
		if(this.checkAddress(a).equals("success")) {
		add.setType(a.getType());
		add.setLine1(a.getLine1());
		add.setLine2(a.getLine2());
		add.setCity(a.getCity());
		add.setState(a.getState());
		add.setZip(a.getZip());
		
        addressRepo.save(add);
        errorMessage.setMessage("Address saved successfully.");
        return new ResponseEntity<>(errorMessage, HttpStatus.OK);
		}
		
		else {
			errorMessage.setMessage("Provide/Correct address details!");
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
		}
	}
	
	public String checkAddress(Address a) {
		if(a.getCity()!=null && a.getState()!=null && a.getLine1()!=null && a.getType()!=null && a.getZip()!=0)
			return "success";
		else
			return "failure";
	}
}
