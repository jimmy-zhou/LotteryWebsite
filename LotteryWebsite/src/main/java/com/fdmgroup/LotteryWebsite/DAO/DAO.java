package com.fdmgroup.LotteryWebsite.DAO;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.LotteryWebsite.entities.Bet;
import com.fdmgroup.LotteryWebsite.entities.Draw;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

public class DAO<T> {

	private EntityManagerFactory emf;

	public DAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void add(T t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(t);
		et.commit();
		em.close();
	}

	public Player getPlayer(String username) {
		EntityManager em = emf.createEntityManager();
		Player returnedPlayer = em.find(Player.class, username);
		em.close();
		return returnedPlayer;
	}

	public State getState(String stateName) {
		EntityManager em = emf.createEntityManager();
		State returnedState = em.find(State.class, stateName);
		em.close();
		return returnedState;
	}

	public Bet getBet(int betId) {
		EntityManager em = emf.createEntityManager();
		Bet returnedBet = em.find(Bet.class, betId);
		em.close();
		return returnedBet;
	}

	public Draw getDraw(Date drawDate) {
		EntityManager em = emf.createEntityManager();
		Draw returnedDraw = em.find(Draw.class, drawDate);
		em.close();
		return returnedDraw;
	}

}
