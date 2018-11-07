package com.fdmgroup.LotteryWebsite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATES")
public class State {

	@Id
	private String state_name;
	
	private double tax_rate;

	public State(String state_name, double tax_rate) {
		super();
		this.state_name = state_name;
		this.tax_rate = tax_rate;
	}

	public State() {
		super();
	}

	@Override
	public String toString() {
		return "State [state_name=" + state_name + ", tax_rate=" + tax_rate + "]";
	}

	public double getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(double tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

}
