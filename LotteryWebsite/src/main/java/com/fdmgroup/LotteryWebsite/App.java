package com.fdmgroup.LotteryWebsite;

import javax.persistence.*;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lotteryWebsite");
		DAO<Player> playerDAO = new DAO<Player>(emf);

		Player p1 = new Player(1, "Jimmy", "Zhou", 1, "jimmy66666", "welcome123", 5367225573712894L);
		Player p2 = new Player(2, "Darren", "Ng", 4, "codingMaster", "passpass", 3769884753129946L);
		Player p3 = new Player(3, "Chris", "Spencer", 2, "bigChris", "shijielong", 4399500021425476L);
		
		playerDAO.add(p3);
		
		System.out.println(playerDAO.get(1));

	}
}
