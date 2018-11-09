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

	@ManyToOne
	@JoinColumn(name = "state_name")
	private State state;

	private String first_name;
	private String last_name;

	private String password;
	private String credit_card;

	public Player(String username, State state, String first_name, String last_name, String password,
			String credit_card) {
		super();
		this.username = username;
		this.state = state;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.credit_card = credit_card;
	}

	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Player [username=" + username + ", state=" + state + ", first_name=" + first_name + ", last_name="
				+ last_name + ", password=" + password + ", credit_card=" + credit_card + "]";
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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

	public String getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}

}
