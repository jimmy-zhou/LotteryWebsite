package com.fdmgroup.LotteryWebsite.runner;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.persistence.*;

import com.fdmgroup.LotteryWebsite.DAO.DAO;
import com.fdmgroup.LotteryWebsite.entities.Bet;
import com.fdmgroup.LotteryWebsite.entities.Draw;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lotteryWebsite");
		
		DAO<State> stateDAO = new DAO<State>(emf);
		
		State s1 = new State("NY", 8.875);
		State s2 = new State("CA", 10.25);
		State s3 = new State("NJ", 12.875);
		State s4 = new State("WA", 10.4);
		State s5 = new State("SC", 9);
		State s6 = new State("PA", 8);
		State s7 = new State("FL", 7.5);
		State s8 = new State("VA", 6);
		State s9 = new State("OR", 0);
		State s10 = new State("AZ", 10.725);

		stateDAO.add(s1);
		stateDAO.add(s2);
		stateDAO.add(s3);
		stateDAO.add(s4);
		stateDAO.add(s5);
		stateDAO.add(s6);
		stateDAO.add(s7);
		stateDAO.add(s8);
		stateDAO.add(s9);
		stateDAO.add(s10);
		
		DAO<Player> playerDAO = new DAO<Player>(emf);

		Player p1 = new Player("jimmy66666", s1, "Jimmy", "Zhou", "welcome123", "5251074893703553");
		Player p2 = new Player("shijielong", s2, "Chris", "Spencer", "shijielong", "4716133766294967");

		playerDAO.add(p1);
		playerDAO.add(p2);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 10, 03);
		Date date1 = new Date(calendar.getTime().getTime());
		calendar.set(2018, 10, 10);
		Date date2 = new Date(calendar.getTime().getTime());
		DAO<Bet> betDAO = new DAO<Bet>(emf);
		Bet b1 = new Bet(p1, date1, pickMainNumber(), pickPowerBallNumber());
		Bet b2 = new Bet(p1, date2, pickMainNumber(), pickPowerBallNumber());
		Bet b3 = new Bet(p2, date1, pickMainNumber(), pickPowerBallNumber());

		betDAO.add(b1);
		betDAO.add(b2);
		betDAO.add(b3);

		DAO<Draw> drawDAO = new DAO<Draw>(emf);
		Draw d1 = new Draw(date1, pickMainNumber(), pickPowerBallNumber(), 1000);
		Draw d2 = new Draw(date2, pickMainNumber(), pickPowerBallNumber(), 10000);
		drawDAO.add(d1);
		drawDAO.add(d2);
		
		System.out.println(playerDAO.getPlayer("jimmy66666"));
		System.out.println(stateDAO.getState("AZ"));
		System.out.println(betDAO.getBet(2));
		System.out.println(drawDAO.getDraw(date2));

	}

	public static String pickMainNumber() {
		String main = new String();
		int[] pick = new int[5];
		Random rand = new Random();
		pick[0] = rand.nextInt(69) + 1;
		for (int i = 1; i < 5; i++) {
			int randInt = rand.nextInt(69) + 1;
			for (int j = 0; j < i; j++) {
				if (randInt == pick[j]) {
					randInt = rand.nextInt(69) + 1;
				}
				pick[i] = randInt;
			}
		}
		for (int i = 0; i < 5; i++) {
			main += pick[i] + " ";
		}
		return main;
	}

	public static int pickPowerBallNumber() {
		Random rand = new Random();
		return rand.nextInt(26) + 1;
	}
}
