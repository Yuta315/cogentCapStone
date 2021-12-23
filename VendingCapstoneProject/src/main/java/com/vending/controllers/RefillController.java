package com.vending.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vending.entities.Refill;
import com.vending.services.RefillService;

@CrossOrigin()
@RestController
@RequestMapping()
public class RefillController {
	
	@Autowired
	private RefillService rs;

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/refills/add")
	public ResponseEntity<Refill> addRefill(@RequestBody Refill rf){
		return ResponseEntity.created(null).body(rs.addRefill(rf));
	};
	
	@GetMapping("/refills/search/today")
	public ResponseEntity<List<Refill>> findToday(){
		return ResponseEntity.created(null).body(rs.findToday());
	};
	
	@GetMapping("/refills/search/all")
	public ResponseEntity<List<Refill>> findAll(){
		return ResponseEntity.created(null).body(rs.findAll());
	};
	//@PreAuthorize("hasAuthority('ADMIN')")
}
