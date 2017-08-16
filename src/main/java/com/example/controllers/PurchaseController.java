package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Purchase;
import com.example.repositories.PurchaseRepository;

@RestController
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;

	@RequestMapping(value = "/purchases", method = RequestMethod.GET)
	private Page<Purchase> listPurchases(int page, int size) {
		return purchaseRepository.findAll(new PageRequest(page, size));

	}

	@RequestMapping(value = "/purchases/{id}", method = RequestMethod.GET)
	private Purchase getPurchase(@PathVariable("id") int id) {
		return purchaseRepository.findOne(id);
	}

	@RequestMapping(value = "/purchases", method = RequestMethod.POST)
	public Purchase savePurchase(@RequestBody @Valid Purchase p) {
		return purchaseRepository.save(p);
	}

	@RequestMapping(value = "/purchases/{id}", method = RequestMethod.PUT)
	public Purchase updatePurchase(@RequestBody Purchase p, @PathVariable("id") int id) {
		p.setIdPurchase(id);
		return purchaseRepository.save(p);

	}

	@RequestMapping(value = "/purchases/{id}", method = RequestMethod.DELETE)
	public void deletePurchase(@PathVariable("id") int id) {
		purchaseRepository.delete(id);
	}

	@RequestMapping(value = "/searchPurchases", method = RequestMethod.GET)
	public Page<Purchase> chercherProduit(int max, int min, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return purchaseRepository.searchPurchase(min, max, new PageRequest(page, size));
	}

}
