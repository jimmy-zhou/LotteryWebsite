package com.fdmgroup.LotteryWebsite;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRAWS")
public class Draw {

	@Id
	private Date date;

	private String main_number;
	private int powerball_number;
	private int accumulated_prize;

	public String getMain_number() {
		return main_number;
	}

	public void setMain_number(String main_number) {
		this.main_number = main_number;
	}

	@Override
	public String toString() {
		return "Draw [date=" + date + ", main_number=" + main_number + ", powerball_number=" + powerball_number
				+ ", accumulated_prize=" + accumulated_prize + "]";
	}

	public Draw(Date date, String main_number, int powerball_number, int accumulated_prize) {
		super();
		this.date = date;
		this.main_number = main_number;
		this.powerball_number = powerball_number;
		this.accumulated_prize = accumulated_prize;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
