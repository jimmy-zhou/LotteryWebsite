package com.fdmgroup.LotteryWebsite.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BETS")
public class Bet {

	@Id
	@Column(name = "bet_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int betId;

	@ManyToOne
	@JoinColumn(name = "username")
	private Player player;

	@Column(name = "draw_date")
	private Date drawDate;

	@Column(name = "main_number")
	private String mainNumber;

	@Column(name = "powerball_number")
	private int powerballNumber;

	public Bet() {
		super();
	}

	public Bet(Player player, Date drawDate, String mainNumber, int powerballNumber) {
		super();
		this.player = player;
		this.drawDate = drawDate;
		this.mainNumber = mainNumber;
		this.powerballNumber = powerballNumber;
	}

	@Override
	public String toString() {
		return "Bet [betId=" + betId + ", player=" + player + ", drawDate=" + drawDate + ", mainNumber=" + mainNumber
				+ ", powerballNumber=" + powerballNumber + "]";
	}

	public int getBetId() {
		return betId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Date getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
	}

	public String getMainNumber() {
		return mainNumber;
	}

	public void setMainNumber(String mainNumber) {
		this.mainNumber = mainNumber;
	}

	public int getPowerballNumber() {
		return powerballNumber;
	}

	public void setPowerballNumber(int powerballNumber) {
		this.powerballNumber = powerballNumber;
	}

}
