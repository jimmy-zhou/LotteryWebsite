package com.fdmgroup.LotteryWebsite;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRIZES")
public class Prize {

	@Id
	private int prize_id;

	private int bet_id;
	private int draw_id;

	public Prize(int prize_id, int bet_id, int draw_id) {
		super();
		this.prize_id = prize_id;
		this.bet_id = bet_id;
		this.draw_id = draw_id;
	}

	@Override
	public String toString() {
		return "Prize [prize_id=" + prize_id + ", bet_id=" + bet_id + ", draw_id=" + draw_id + "]";
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

	public int getDraw_id() {
		return draw_id;
	}

	public void setDraw_id(int draw_id) {
		this.draw_id = draw_id;
	}

	public Prize() {
		super();
	}

}
