package com.vending.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vending.entities.Container;
import com.vending.entities.Refill;
import com.vending.repositories.ContainerRepository;
import com.vending.repositories.RefillRepository;

@Service
public class RefillService {

	@Autowired
	private RefillRepository rr;
	
	@Autowired
	private ContainerRepository cr;
	
	public Refill addRefill(Refill rf) {
		Refill updatedRf = rr.save(rf);
		
		if(updatedRf != null) {
			// update available containers
			Container tmpCtn = cr.getById(1);
			tmpCtn.setCoffeeContainer(tmpCtn.getCoffeeContainer() + (float)updatedRf.getCoffeeRefill() / 1000);
			tmpCtn.setMilkContainer(tmpCtn.getMilkContainer() + (float)updatedRf.getMilkRefill() / 1000);
			tmpCtn.setSugarContainer(tmpCtn.getSugarContainer() + (float)updatedRf.getSugarRefill() / 1000);
			tmpCtn.setTeaContainer(tmpCtn.getTeaContainer() + (float)updatedRf.getTeaRefill() / 1000);
			tmpCtn.setWaterContainer(tmpCtn.getWaterContainer() + (float)updatedRf.getWaterRefill() / 1000);
			cr.save(tmpCtn);
		}
		return updatedRf;
	}
	
	public List<Refill> findToday() {
		return rr.findByToday();
	}
	
	public List<Refill> findAll() {
		return rr.findAll();
	}
	
	
}
