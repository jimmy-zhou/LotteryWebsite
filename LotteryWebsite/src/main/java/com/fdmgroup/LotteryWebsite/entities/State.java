package com.fdmgroup.LotteryWebsite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATES")
public class State {

	@Id
	@Column(name = "state_name")
	private String stateName;

	@Column(name = "tax_rate")
	private double taxRate;

	public State() {
		super();
	}

	public State(String stateName, double taxRate) {
		super();
		this.stateName = stateName;
		this.taxRate = taxRate;
	}

	@Override
	public String toString() {
		return "State [stateName=" + stateName + ", taxRate=" + taxRate + "]";
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

}
