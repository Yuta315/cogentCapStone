package com.vending.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.entities.Drink;
import com.vending.exception.ResourceNotFoundException;
import com.vending.repositories.DrinkRepository;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepository dr;
	
	public List<Drink> getAllDrinks(){
		return dr.findAll();
	}
	
	public Optional<Drink> getDrinkById(int id) throws ResourceNotFoundException
	{
		return dr.findById(id);
	}
}
