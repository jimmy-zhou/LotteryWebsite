package com.fdmgroup.LotteryWebsite.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRIZES")
public class Prize {

	@Id
	@Column(name = "prize_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prizeId;

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

	public Prize(Bet bet, Draw draw, double prize) {
		super();
		this.bet = bet;
		this.draw = draw;
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Prize [prizeId=" + prizeId + ", bet=" + bet + ", draw=" + draw + ", prize=" + prize + "]";
	}

	public int getPrizeId() {
		return prizeId;
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

}
