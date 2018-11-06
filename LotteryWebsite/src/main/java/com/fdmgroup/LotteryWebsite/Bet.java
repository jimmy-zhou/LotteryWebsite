package com.fdmgroup.LotteryWebsite;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BETS")
public class Bet {

	@Id
	private int bet_id;

	private int player_id;
	private int draw_id;
	private int[] main_number;
	private int powerball_number;

	public Bet(int bet_id, int player_id, int draw_id, int[] main_number, int powerball_number) {
		super();
		this.bet_id = bet_id;
		this.player_id = player_id;
		this.draw_id = draw_id;
		this.main_number = main_number;
		this.powerball_number = powerball_number;
	}

	public Bet() {
		super();
	}

	@Override
	public String toString() {
		return "Bet [bet_id=" + bet_id + ", player_id=" + player_id + ", draw_id=" + draw_id + ", main_number="
				+ Arrays.toString(main_number) + ", powerball_number=" + powerball_number + "]";
	}

	public int getBet_id() {
		return bet_id;
	}

	public void setBet_id(int bet_id) {
		this.bet_id = bet_id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getDraw_id() {
		return draw_id;
	}

	public void setDraw_id(int draw_id) {
		this.draw_id = draw_id;
	}

	public int[] getMain_number() {
		return main_number;
	}

	public void setMain_number(int[] main_number) {
		this.main_number = main_number;
	}

	public int getPowerball_number() {
		return powerball_number;
	}

	public void setPowerball_number(int powerball_number) {
		this.powerball_number = powerball_number;
	}

}
