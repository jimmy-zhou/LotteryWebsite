package com.fdmgroup.LotteryWebsite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATES")
public class State {

	@Id
	private int state_id;
	
	private double tax_rate;
	private String state_name;

	public State(int state_id, double tax_rate, String state_name) {
		super();
		this.state_id = state_id;
		this.tax_rate = tax_rate;
		this.state_name = state_name;
	}

	public State() {
		super();
	}

	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", tax_rate=" + tax_rate + ", state_name=" + state_name + "]";
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
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
