package com.fdmgroup.LotteryWebsite;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.persistence.*;

public class App {

	public static void main(String[] args) {

	 EntityManagerFactory emf =
	 Persistence.createEntityManagerFactory("lotteryWebsite");
	 DAO<Player> playerDAO = new DAO<Player>(emf);
	
	 Player p1 = new Player("jimmy66666", "NY", "Jimmy", "Zhou", "welcome123", 5367225573712894L);
	 Player p2 = new Player("codingMaster", "CA", "Darren", "Ng", "passpass", 3769884753129946L);
	 Player p3 = new Player("bigChris", "NJ", "Chris", "Spencer", "shijielong", 4399500021425476L);
	
	 playerDAO.add(p1);
	 playerDAO.add(p2);
	 playerDAO.add(p3);
	
//	 System.out.println(pickMainNumber());
	
	 DAO<State> stateDAO = new DAO<State>(emf);
	 State s1 = new State("NY", 8.875);
	 State s2 = new State("CA", 10.25);
	 State s3 = new State("NJ", 12.875);
	
	 stateDAO.add(s1);
	 stateDAO.add(s2);
	 stateDAO.add(s3);
	
	 Calendar calendar = Calendar.getInstance();
	 calendar.set(2018, 10, 07);
	 Date date1 = new Date(calendar.getTime().getTime());
	 System.out.println(date1);
//	 DAO<Bet> betDAO = new DAO<Bet>(emf);
//	 Bet b1 = new Bet(1, "jimmy66666", date1, pickMainNumber(), pickPowerBallNumber());
//	 Bet b2 = new Bet(2, "jimmy66666", date1, pickMainNumber(), pickPowerBallNumber());
//	 Bet b3 = new Bet(3, "bigChris", date1, pickMainNumber(), pickPowerBallNumber());
//	
//	 betDAO.add(b1);
//	 betDAO.add(b2);
//	 betDAO.add(b3);

	 System.out.println(pickPowerBallNumber());
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
