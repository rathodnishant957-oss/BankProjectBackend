package com.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TraHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	private String traType;
	//deposite or withdraw
	private double traAmount;
	private String traDate;
	private String traTime;
	
	
	// Setter and Getter

	public int getTId() {
		return tId;
	}
	public void setTId(int tId) {
		this.tId = tId;
	}
	public String getTraType() {
		return traType;
	}
	public void setTraType(String traType) {
		this.traType = traType;
	}
	public Double getTraAmount() {
		return traAmount;
	}
	public void setTraAmount(Double traAmount) {
		this.traAmount = traAmount;
	}
	public String getTraDate() {
		return traDate;
	}
	public void setTraDate(String traDate) {
		this.traDate = traDate;
	}
	public String getTraTime() {
		return traTime;
	}
	public void setTraTime(String traTime) {
		this.traTime = traTime;
	}
	
	
	
}
