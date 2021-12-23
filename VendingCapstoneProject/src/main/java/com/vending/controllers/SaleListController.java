package com.vending.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vending.entities.SaleList;
import com.vending.exception.ResourceNotFoundException;
import com.vending.services.SaleListService;

@CrossOrigin()
@RestController
@RequestMapping()
public class SaleListController {
	@Autowired
	private SaleListService sls;
	
	@PostMapping("/saleLists/add")
	public ResponseEntity<SaleList> addSale(@RequestBody SaleList p) 
			throws ResourceNotFoundException{
		return ResponseEntity.created(null).body(sls.addSale(p));
	}
	
	@GetMapping("/saleLists/{id}")
    public ResponseEntity <SaleList> getSaleById(@PathVariable(value = "id") int id)
    throws ResourceNotFoundException {
        SaleList sl = sls.getSaleById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Sale not found for this id :: " + id));
        return ResponseEntity.created(null).body(sl);
    }
	
	@GetMapping("/saleLists")
	public ResponseEntity<List<SaleList>> findAll(){
		return ResponseEntity.created(null).body(sls.findAll());
	};
	
	@GetMapping("/saleLists/search/today/{drinkId}")
	public ResponseEntity<List<SaleList>> findToday(@PathVariable("drinkId") int drinkId){
		return ResponseEntity.created(null).body(sls.findByToday(drinkId));
	};
	
	@GetMapping("/saleLists/search/{drinkId}")
	public ResponseEntity<List<SaleList>> findByDrinkId(@PathVariable("drinkId") int drinkId){
		return ResponseEntity.created(null).body(sls.findByDrinkId(drinkId));
	};
}
