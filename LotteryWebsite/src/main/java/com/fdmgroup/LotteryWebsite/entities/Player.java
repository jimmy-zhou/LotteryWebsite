package com.fdmgroup.LotteryWebsite.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYERS")
public class Player {

	@Id
	private String username;
	
	private String state_name;
	
	private String first_name;
	private String last_name;
	
	private String password;
	private long credit_card_number;

	public Player(String username, String state_name, String first_name, String last_name, String password,
			long credit_card_number) {
		super();
		this.username = username;
		this.state_name = state_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.credit_card_number = credit_card_number;
	}

	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Player [username=" + username + ", state_name=" + state_name + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", password=" + password + ", credit_card_number=" + credit_card_number
				+ "]";
	}

	@ManyToOne
	@JoinColumn(name = "state_name")
	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getCredit_card_number() {
		return credit_card_number;
	}

	public void setCredit_card_number(long credit_card_number) {
		this.credit_card_number = credit_card_number;
	}

}
