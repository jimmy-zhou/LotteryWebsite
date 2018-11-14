package com.fdmgroup.LotteryWebsite.DAO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.LotteryWebsite.entities.Bet;

public class BetDAO {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void addBet(Bet b) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(b);
		et.commit();
		em.close();
	}

	public Bet getBet(int betId) {
		EntityManager em = emf.createEntityManager();
		Bet returnedBet = em.find(Bet.class, betId);
		em.close();
		return returnedBet;
	}
}
