package com.vending.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="SALE_LIST")
public class SaleList implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SALE_ID")
	private int saleListId;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "drinkId", nullable = false)
	private Drink drink;
	
	@Column(name="NUMBER_OF_CUP")
	private int numberOfCup;
	
	@Column(name="DATE")
	private Date date;
	
	public SaleList() {
		super();
	}
	
	public SaleList(int saleListId, Drink drink, int numberOfCup, Date date) {
		super();
		this.saleListId = saleListId;
		this.drink = drink;
		this.numberOfCup = numberOfCup;
		this.date = date;
	}

	public int getSaleListId() {
		return saleListId;
	}

	public void setSaleListId(int saleListId) {
		this.saleListId = saleListId;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public int getNumberOfCup() {
		return numberOfCup;
	}

	public void setNumberOfCup(int numberOfCup) {
		this.numberOfCup = numberOfCup;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "SaleList [saleListId=" + saleListId + ", drink=" + drink + ", numberOfCup=" + numberOfCup + ", date="
				+ date + "]";
	}
}
