package com.pinhobrunodev.hrpayroll.entities;

import java.io.Serializable;


// Nao possui banco de dados 
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private Double dayliIncome;
	private Integer days;
	
	public Payment() {
		
	}
	
	
	public Payment(String name, Double dayliIncome, Integer days) {
		super();
		this.name = name;
		this.dayliIncome = dayliIncome;
		this.days = days;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getDayliIncome() {
		return dayliIncome;
	}


	public void setDayliIncome(Double dayliIncome) {
		this.dayliIncome = dayliIncome;
	}


	public Integer getDays() {
		return days;
	}


	public void setDays(Integer days) {
		this.days = days;
	}
	
	public Double getTotal() {
		return dayliIncome*days;
	}
	
	
	
}
