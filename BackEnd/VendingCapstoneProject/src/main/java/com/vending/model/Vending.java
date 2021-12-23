//package com.vending.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "vending")
//
//
//public class Vending {
//	
//	// Tea, Coffee, Sugar, Water, Milk
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	private float tea;
//	private float coffee;
//	private float sugar;
//	private float water;
//	private float milk;
//
///*	
//	public float getTea() {
//		return tea;
//	}
//	public void setTea(float tea) {
//		this.tea = tea;
//	}
//	public float getCoffee() {
//		return coffee;
//	}
//	public void setCoffee(float coffee) {
//		this.coffee = coffee;
//	}
//	public float getSugar() {
//		return sugar;
//	}
//	public void setSugar(float sugar) {
//		this.sugar = sugar;
//	}
//	public float getWater() {
//		return water;
//	}
//	public void setWater(float water) {
//		this.water = water;
//	}
//	public float getMilk() {
//		return milk;
//	}
//	public void setMilk(float milk) {
//		this.milk = milk;
//	}
//*/
//	
//    @Override
//    public String toString() {
//        return "Vending [tea = " + tea + ", coffee = " + coffee + ", Sugar = " + sugar + 
//        		", Water = " + water + "Milk = " + milk + "]";
//    }
//	
//}
