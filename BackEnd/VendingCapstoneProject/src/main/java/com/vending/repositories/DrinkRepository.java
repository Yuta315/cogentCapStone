package com.vending.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vending.entities.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Integer>{

}
