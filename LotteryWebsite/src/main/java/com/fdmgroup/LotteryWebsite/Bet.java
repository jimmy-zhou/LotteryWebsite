package com.fdmgroup.LotteryWebsite;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BETS")
public class Bet {

	@Id
	private int bet_id;

	private String username;
	private Date date;
	private String main_number;
	private int powerball_number;

	public Bet(int bet_id, String username, Date date, String main_number, int powerball_number) {
		super();
		this.bet_id = bet_id;
		this.username = username;
		this.date = date;
		this.main_number = main_number;
		this.powerball_number = powerball_number;
	}

	public Bet() {
		super();
	}

	@Override
	public String toString() {
		return "Bet [bet_id=" + bet_id + ", username=" + username + ", date=" + date + ", main_number=" + main_number
				+ ", powerball_number=" + powerball_number + "]";
	}

	public int getBet_id() {
		return bet_id;
	}

	public void setBet_id(int bet_id) {
		this.bet_id = bet_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMain_number() {
		return main_number;
	}

	public void setMain_number(String main_number) {
		this.main_number = main_number;
	}

	public int getPowerball_number() {
		return powerball_number;
	}

	public void setPowerball_number(int powerball_number) {
		this.powerball_number = powerball_number;
	}

}
