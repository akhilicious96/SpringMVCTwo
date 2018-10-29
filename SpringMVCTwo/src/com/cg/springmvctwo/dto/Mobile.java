package com.cg.springmvctwo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="MobileOneData")
public class Mobile {
	
	@Override
	public String toString() {
		return "Mobile [mobId=" + mobId + ", mobName=" + mobName
				+ ", mobPrice=" + mobPrice + ", mobCategory=" + mobCategory
				+ ", mobOnline=" + mobOnline + "]";
	}

	@Id
	@Column(name="mob_id")
	@NotNull(message="Mobile Id cannot be empty")
	Integer mobId;
	
	@Column(name="mob_name")
	@NotEmpty(message = "Name acannot be empty")
	String mobName;
	
	@Column(name="mob_price")
	@NotNull(message = "Price cannit be empty")
	Double mobPrice;
	
	@Column(name="mob_cato")
	@NotEmpty(message = "Category Name acannot be empty")
	String mobCategory;
	
	@Column(name="mob_online")
	@NotEmpty(message = "Mobile availability acannot be empty")
	String mobOnline;
	
	
	public Mobile() {
		
	}
	
	

	public Mobile(Integer mobId, String mobName, Double mobPrice, String mobCatogory, String mobOnline) {
		super();
		this.mobId = mobId;
		this.mobName = mobName;
		this.mobPrice = mobPrice;
		this.mobCategory = mobCatogory;
		this.mobOnline= mobOnline;
	}



	public String getMobOnline() {
		return mobOnline;
	}



	public void setMobOnline(String mobOnline) {
		this.mobOnline = mobOnline;
	}



	public Integer getMobId() {
		return mobId;
	}
	
	public void setMobId(Integer mobId) {
		this.mobId = mobId;
	}
	
	public String getMobName() {
		return mobName;
	}
	
	public void setMobName(String mobName) {
		this.mobName = mobName;
	}
	
	public Double getMobPrice() {
		return mobPrice;
	}
	
	public void setMobPrice(Double mobPrice) {
		this.mobPrice = mobPrice;
	}
	
	public String getMobCategory() {
		return mobCategory;
	}
	
	public void setMobCategory(String mobCategory) {
		this.mobCategory = mobCategory;
	}
	
	
	
}
