package com.vending.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REFILL")
public class Refill implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REFILL_ID")
	private int refillId;
	
	@Column(name = "TEA_RF")
	private int teaRefill;
	
	@Column(name = "COFFEE_RF")
	private int coffeeRefill;
	
	@Column(name = "SUGAR_RF")
	private int sugarRefill;
	
	@Column(name = "WATER_RF")
	private int waterRefill;
	
	@Column(name = "MIKL_RF")
	private int milkRefill;
	
	@Column(name = "DATE")
	private Date date;
	
	public Refill() {
		super();
	}
	
	public Refill(int refillId, int teaRefill, int coffeeRefill, int sugarRefill, int waterRefill, int milkRefill,
			Date date) {
		super();
		this.refillId = refillId;
		this.teaRefill = teaRefill;
		this.coffeeRefill = coffeeRefill;
		this.sugarRefill = sugarRefill;
		this.waterRefill = waterRefill;
		this.milkRefill = milkRefill;
		this.date = date;
	}

	public int getRefillId() {
		return refillId;
	}

	public void setRefillId(int refillId) {
		this.refillId = refillId;
	}

	public int getTeaRefill() {
		return teaRefill;
	}

	public void setTeaRefill(int teaRefill) {
		this.teaRefill = teaRefill;
	}

	public int getCoffeeRefill() {
		return coffeeRefill;
	}

	public void setCoffeeRefill(int coffeeRefill) {
		this.coffeeRefill = coffeeRefill;
	}

	public int getSugarRefill() {
		return sugarRefill;
	}

	public void setSugarRefill(int sugarRefill) {
		this.sugarRefill = sugarRefill;
	}

	public int getWaterRefill() {
		return waterRefill;
	}

	public void setWaterRefill(int waterRefill) {
		this.waterRefill = waterRefill;
	}

	public int getMilkRefill() {
		return milkRefill;
	}

	public void setMilkRefill(int milkRefill) {
		this.milkRefill = milkRefill;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Refill [refillId=" + refillId + ", teaRefill=" + teaRefill + ", coffeeRefill=" + coffeeRefill
				+ ", sugarRefill=" + sugarRefill + ", waterRefill=" + waterRefill + ", milkRefill=" + milkRefill
				+ ", date=" + date + "]";
	}
}
