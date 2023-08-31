package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {
	
	@Id
	private int custid;
	private String custname;
	private String theme;
	private String caketype;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cakeid")
	private CakeEntity cs;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_foodid")
	private List<FoodEntity> cp;

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(int custid, String custname, String theme, String caketype, CakeEntity cs,
			List<FoodEntity> cp) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.theme = theme;
		this.caketype = caketype;
		this.cs = cs;
		this.cp = cp;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getCaketype() {
		return caketype;
	}

	public void setCaketype(String caketype) {
		this.caketype = caketype;
	}

	public CakeEntity getCs() {
		return cs;
	}

	public void setCs(CakeEntity cs) {
		this.cs = cs;
	}

	public List<FoodEntity> getCp() {
		return cp;
	}

	public void setCp(List<FoodEntity> cp) {
		this.cp = cp;
	}

	

	
	
}
