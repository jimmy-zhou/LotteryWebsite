package com.fdmgroup.LotteryWebsite.entities;

import javax.persistence.Column;
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

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(nullable = false)
	private String password;

	@Column(name = "credit_card")
	private String creditCard;

	public Player() {
		super();
	}

	public Player(String username, State state, String firstName, String lastName, String password, String creditCard) {
		super();
		this.username = username;
		this.state = state;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		return "Player [username=" + username + ", state=" + state + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", creditCard=" + creditCard + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
