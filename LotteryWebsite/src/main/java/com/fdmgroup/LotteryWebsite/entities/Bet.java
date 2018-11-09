package com.fdmgroup.LotteryWebsite.entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BETS")
public class Bet {

	@Id
	private int bet_id;
	
	@ManyToOne
	@JoinColumn(name="username")
	private Player player;
	
	private Date draw_date;
	private String main_number;
	private int powerball_number;
	

	public Bet() {
		super();
	}

	public Bet(int bet_id, Player player, Date draw_date, String main_number, int powerball_number) {
		super();
		this.bet_id = bet_id;
		this.player = player;
		this.draw_date = draw_date;
		this.main_number = main_number;
		this.powerball_number = powerball_number;
	}

	@Override
	public String toString() {
		return "Bet [bet_id=" + bet_id + ", player=" + player + ", draw_date=" + draw_date + ", main_number="
				+ main_number + ", powerball_number=" + powerball_number + "]";
	}

	public int getBet_id() {
		return bet_id;
	}

	public void setBet_id(int bet_id) {
		this.bet_id = bet_id;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Date getDraw_date() {
		return draw_date;
	}

	public void setDraw_date(Date draw_date) {
		this.draw_date = draw_date;
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
