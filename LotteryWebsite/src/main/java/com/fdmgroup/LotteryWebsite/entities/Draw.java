package com.fdmgroup.LotteryWebsite.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRAWS")
public class Draw {

	@Id
	@Column(name = "draw_date")
	private Date drawDate;

	@Column(name = "main_number")
	private String mainNumber;

	@Column(name = "powerball")
	private int powerballNumber;

	@Column(name = "accumulated_prize")
	private int accumulatedPrize;

	public Draw() {
		super();
	}

	public Draw(Date drawDate, String mainNumber, int powerballNumber, int accumulatedPrize) {
		super();
		this.drawDate = drawDate;
		this.mainNumber = mainNumber;
		this.powerballNumber = powerballNumber;
		this.accumulatedPrize = accumulatedPrize;
	}

	@Override
	public String toString() {
		return "Draw [drawDate=" + drawDate + ", mainNumber=" + mainNumber + ", powerballNumber=" + powerballNumber
				+ ", accumulatedPrize=" + accumulatedPrize + "]";
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

	public int getAccumulatedPrize() {
		return accumulatedPrize;
	}

	public void setAccumulatedPrize(int accumulatedPrize) {
		this.accumulatedPrize = accumulatedPrize;
	}

}
