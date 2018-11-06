package com.fdmgroup.LotteryWebsite;

import java.util.Random;

import javax.persistence.*;

public class App {

	public static void main(String[] args) {

	 EntityManagerFactory emf =
	 Persistence.createEntityManagerFactory("lotteryWebsite");
	 DAO<Player> playerDAO = new DAO<Player>(emf);
	
	 Player p1 = new Player(1, "Jimmy", "Zhou", 1, "jimmy66666", "welcome123",
	 5367225573712894L);
	 Player p2 = new Player(2, "Darren", "Ng", 3, "codingMaster", "passpass",
	 3769884753129946L);
	 Player p3 = new Player(3, "Chris", "Spencer", 2, "bigChris", "shijielong",
	 4399500021425476L);
	
	 playerDAO.add(p1);
	 playerDAO.add(p2);
	 playerDAO.add(p3);
	
	 System.out.println(playerDAO.getPlayer(1));
	
	 DAO<State> stateDAO = new DAO<State>(emf);
	 State s1 = new State(1, 8.875, "NY");
	 State s2 = new State(2, 10.25, "CA");
	 State s3 = new State(3, 12.875, "NJ");
	
	 stateDAO.add(s1);
	 stateDAO.add(s2);
	 stateDAO.add(s3);
	
	 DAO<Bet> betDAO = new DAO<Bet>(emf);
	 Bet b1 = new Bet(1, 1, 1, pickMainNumber(), 5);
	 Bet b2 = new Bet(2, 1, 1, pickMainNumber(), 5);
	 Bet b3 = new Bet(3, 1, 1, pickMainNumber(), 5);
	
	 betDAO.add(b1);
	 betDAO.add(b2);
	 betDAO.add(b3);

	}

	public static int[] pickMainNumber() {
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
		return pick;
	}
}
