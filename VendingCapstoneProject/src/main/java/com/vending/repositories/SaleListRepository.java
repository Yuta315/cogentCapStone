package com.vending.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.vending.entities.*;

@Repository
public interface SaleListRepository extends JpaRepository<SaleList, Integer>{
	List<SaleList> findByDrinkId(@RequestParam("id") int id);
	
	@Query("SELECT s from SaleList s where (DATE_FORMAT(s.date,'%Y-%M-%d') = DATE_FORMAT(current_date,'%Y-%M-%d'))"
			+ "AND s.drink.id = ?1")
	List<SaleList> findByToday(@RequestParam("drinkId") int drinkId);
	
}
