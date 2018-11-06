package com.fdmgroup.LotteryWebsite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYERS")
public class Player {

	@Id
	private int player_id;
	
	private String first_name;
	private String last_name;
	private int state_id;
	private String username;
	private String password;
	private long credit_card_number;

	public Player(int player_id, String first_name, String last_name, int state_id, String username, String password,
			long credit_card_number) {
		super();
		this.player_id = player_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.state_id = state_id;
		this.username = username;
		this.password = password;
		this.credit_card_number = credit_card_number;
	}

	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Player [player_id=" + player_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", state_id=" + state_id + ", username=" + username + ", password=" + password
				+ ", credit_card_number=" + credit_card_number + "]";
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
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

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
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
