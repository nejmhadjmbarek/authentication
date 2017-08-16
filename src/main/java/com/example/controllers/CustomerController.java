package com.example.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Customer;
import com.example.entities.Purchase;
import com.example.repositories.CustomerRepository;
import com.example.repositories.PurchaseRepository;

@RestController
public class CustomerController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping(value = "/customer/list", method = RequestMethod.GET)
	private Page<Customer> listCustomers(int page, int size) {
		return customerRepository.findAll(new PageRequest(page, size));

	}

	@RequestMapping(value = "/customer/purchases/{idCustomer}", method = RequestMethod.GET)
	public Page<Purchase> getPurchaseByCustomer(@PathVariable("idCustomer") int idCustomer,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		return purchaseRepository.getPurchaseByIdCustomer(idCustomer, new PageRequest(page, size));

	}
	
	@RequestMapping("/resource")
	  public Map<String,Object> home() {
	    Map<String,Object> model = new HashMap<String,Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	  }
	
	
	
	
	
	
	
}
