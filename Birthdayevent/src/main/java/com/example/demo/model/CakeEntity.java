package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cake")
public class CakeEntity {

	private String fl;
	private int weight;
	@Id
	private int cakeid;
	public CakeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CakeEntity(String fl, int weight, int cakeid) {
		super();
		this.fl = fl;
		this.weight = weight;
		this.cakeid = cakeid;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCakeid() {
		return cakeid;
	}
	public void setCakeid(int cakeid) {
		this.cakeid = cakeid;
	}
	
}
