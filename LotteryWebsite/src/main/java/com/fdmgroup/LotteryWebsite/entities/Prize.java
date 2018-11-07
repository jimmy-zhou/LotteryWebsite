package com.fdmgroup.LotteryWebsite.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRIZES")
public class Prize {

	@Id
	private int prize_id;

	private int bet_id;
	private Date draw_date;

	private double prize;

	public Prize(int prize_id, int bet_id, Date draw_date, double prize) {
		super();
		this.prize_id = prize_id;
		this.bet_id = bet_id;
		this.draw_date = draw_date;
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Prize [prize_id=" + prize_id + ", bet_id=" + bet_id + ", draw_date=" + draw_date + ", prize=" + prize
				+ "]";
	}

	public Date getDraw_date() {
		return draw_date;
	}

	public void setDraw_date(Date draw_date) {
		this.draw_date = draw_date;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public int getPrize_id() {
		return prize_id;
	}

	public void setPrize_id(int prize_id) {
		this.prize_id = prize_id;
	}

	public int getBet_id() {
		return bet_id;
	}

	public void setBet_id(int bet_id) {
		this.bet_id = bet_id;
	}

	public Prize() {
		super();
	}

}
