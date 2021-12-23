package com.vending.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Drink")
public class Drink implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DRINK_ID")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "cost")
	private double cost;
	
	@Column(name = "sugar")
	private int sugar;
	
	@Column(name = "tea")
	private int tea;
	
	@Column(name = "coffee")
	private int coffee;
	
	@Column(name = "milk")
	private int milk;
	
	@Column(name = "water")
	private int water;
	
	@JsonManagedReference	
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "drink")
    private Set<SaleList> saleLists;
	
	public Drink() {
		super();
	}

	public Drink(int id, String name, double cost, int sugar, int tea, int coffee, int milk, int water) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.sugar = sugar;
		this.tea = tea;
		this.coffee = coffee;
		this.milk = milk;
		this.water = water;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public int getTea() {
		return tea;
	}

	public void setTea(int tea) {
		this.tea = tea;
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public Set<SaleList> getSaleLists() {
		return saleLists;
	}

	public void setSaleLists(Set<SaleList> saleLists) {
		this.saleLists = saleLists;
	}
	
	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", cost=" + cost + ", sugar=" + sugar + ", tea=" + tea
				+ ", coffee=" + coffee + ", milk=" + milk + ", water=" + water + ", saleLists=" + saleLists + "]";
	}
	
}
