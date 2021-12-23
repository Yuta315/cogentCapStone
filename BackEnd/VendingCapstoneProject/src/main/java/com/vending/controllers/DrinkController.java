package com.vending.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vending.entities.Drink;
import com.vending.exception.ResourceNotFoundException;
import com.vending.services.DrinkService;

@CrossOrigin()
@RestController
@RequestMapping()
public class DrinkController {
	@Autowired
	private DrinkService ds;
	
	@GetMapping("/drinks")
    public ResponseEntity <List<Drink>> getAllDrink(){
        return ResponseEntity.created(null).body(ds.getAllDrinks());
    }
	
	@GetMapping("/drinks/{id}")
    public ResponseEntity <Drink> getById(@PathVariable("id") int id)
		throws ResourceNotFoundException {
	        Drink dr = ds.getDrinkById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Drink not found for this id :: " + id));
	        return ResponseEntity.created(null).body(dr);
	    }
}
