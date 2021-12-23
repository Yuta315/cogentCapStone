package com.vending.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTAINER")
public class Container {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CTN_ID")
	private int id;
	
	@Column(name = "TEA")
	private float teaContainer;
	
	@Column(name = "COFFEE")
	private float coffeeContainer;
	
	@Column(name = "SUGAR")
	private float sugarContainer;
	
	@Column(name = "WATER")
	private float waterContainer;

	@Column(name = "MILK")
	private float milkContainer;
	
	public Container() {
		super();
	};
	
	public Container(int id, float teaContainer, float coffeeContainer, float sugarContainer, float waterContainer,
			float milkContainer) {
		super();
		this.id = id;
		this.teaContainer = teaContainer;
		this.coffeeContainer = coffeeContainer;
		this.sugarContainer = sugarContainer;
		this.waterContainer = waterContainer;
		this.milkContainer = milkContainer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getTeaContainer() {
		return teaContainer;
	}

	public void setTeaContainer(float teaContainer) {
		this.teaContainer = teaContainer;
	}

	public float getCoffeeContainer() {
		return coffeeContainer;
	}

	public void setCoffeeContainer(float coffeeContainer) {
		this.coffeeContainer = coffeeContainer;
	}

	public float getSugarContainer() {
		return sugarContainer;
	}

	public void setSugarContainer(float sugarContainer) {
		this.sugarContainer = sugarContainer;
	}

	public float getWaterContainer() {
		return waterContainer;
	}

	public void setWaterContainer(float waterContainer) {
		this.waterContainer = waterContainer;
	}

	public float getMilkContainer() {
		return milkContainer;
	}

	public void setMilkContainer(float milkContainer) {
		this.milkContainer = milkContainer;
	};
	
	@Override
	public String toString() {
		return "Container [id=" + id + ", teaContainer=" + teaContainer + ", coffeeContainer=" + coffeeContainer
				+ ", sugarContainer=" + sugarContainer + ", waterContainer=" + waterContainer + ", milkContainer="
				+ milkContainer + "]";
	}
}
