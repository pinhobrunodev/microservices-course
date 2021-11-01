package com.pinhobrunodev.hrworker.dto;

import com.pinhobrunodev.hrworker.entities.Worker;

public class WorkerDTO {

	private Long id;
	private String name;
	private Double dailyIncome;
		
	
	public WorkerDTO() {
		
	}
	
	public WorkerDTO(Worker entity) {
		id = entity.getId();
		name = entity.getName();
		dailyIncome = entity.getDailyIncome();
	}

	
	public WorkerDTO(Long id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	
}
