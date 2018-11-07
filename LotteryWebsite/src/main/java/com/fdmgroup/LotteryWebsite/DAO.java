package com.fdmgroup.LotteryWebsite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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

	public Player getPlayer(int player_id) {
		EntityManager em = emf.createEntityManager();
		Player returned_player = em.find(Player.class, player_id);
		em.close();
		return returned_player;
	}
	
	public State getState(String state_name) {
		EntityManager em = emf.createEntityManager();
		State returned_state = em.find(State.class, state_name);
		em.close();
		return returned_state;
	}

}
