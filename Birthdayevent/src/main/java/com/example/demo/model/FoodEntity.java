package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Food")
public class FoodEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodid;
	private String briyani;
	private String dosa;
	private String sweet;
	public FoodEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodEntity(int foodid, String briyani, String dosa, String sweet) {
		super();
		this.foodid = foodid;
		this.briyani = briyani;
		this.dosa = dosa;
		this.sweet = sweet;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public String getBriyani() {
		return briyani;
	}
	public void setBriyani(String briyani) {
		this.briyani = briyani;
	}
	public String getDosa() {
		return dosa;
	}
	public void setDosa(String dosa) {
		this.dosa = dosa;
	}
	public String getSweet() {
		return sweet;
	}
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	
	
	
}
