package com.fdmgroup.LotteryWebsite;

import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRAWS")
public class Draw {

	@Id
	private int draw_id;

	private Calendar date;
	private int[] main_number;
	private int powerball_number;
	private int accumulated_prize;

	public Draw(int draw_id, Calendar date, int[] main_number, int powerball_number, int accumulated_prize) {
		super();
		this.draw_id = draw_id;
		this.date = date;
		this.main_number = main_number;
		this.powerball_number = powerball_number;
		this.accumulated_prize = accumulated_prize;
	}

	@Override
	public String toString() {
		return "Draw [draw_id=" + draw_id + ", date=" + date + ", main_number=" + Arrays.toString(main_number)
				+ ", powerball_number=" + powerball_number + ", accumulated_prize=" + accumulated_prize + "]";
	}

	public int getDraw_id() {
		return draw_id;
	}

	public void setDraw_id(int draw_id) {
		this.draw_id = draw_id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
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

	public int getAccumulated_prize() {
		return accumulated_prize;
	}

	public void setAccumulated_prize(int accumulated_prize) {
		this.accumulated_prize = accumulated_prize;
	}

	public Draw() {
		super();
	}

}
