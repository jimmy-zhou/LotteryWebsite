package com.fdmgroup.LotteryWebsite.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRIZES")
public class Prize {

	@Id
	private int prize_id;

	@OneToOne
	@JoinColumn(name = "bet_id")
	private Bet bet;
	@ManyToOne
	@JoinColumn(name = "draw_date")
	private Draw draw;

	private double prize;

	public Prize() {
		super();
	}

	public Prize(int prize_id, Bet bet, Draw draw, double prize) {
		super();
		this.prize_id = prize_id;
		this.bet = bet;
		this.draw = draw;
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Prize [prize_id=" + prize_id + ", bet=" + bet + ", draw=" + draw + ", prize=" + prize + "]";
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public Draw getDraw() {
		return draw;
	}

	public void setDraw(Draw draw) {
		this.draw = draw;
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

}
