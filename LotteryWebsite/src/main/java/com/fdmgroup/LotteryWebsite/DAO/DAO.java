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
		Player returned_player = em.find(Player.class, username);
		em.close();
		return returned_player;
	}
	
	public State getState(String state_name) {
		EntityManager em = emf.createEntityManager();
		State returned_state = em.find(State.class, state_name);
		em.close();
		return returned_state;
	}
	
	public Bet getBet(int bet_id) {
		EntityManager em = emf.createEntityManager();
		Bet returned_bet = em.find(Bet.class, bet_id);
		em.close();
		return returned_bet;
	}
	
	public Draw getDraw(Date draw_date) {
		EntityManager em = emf.createEntityManager();
		Draw returned_draw = em.find(Draw.class, draw_date);
		em.close();
		return returned_draw;
	}

}
