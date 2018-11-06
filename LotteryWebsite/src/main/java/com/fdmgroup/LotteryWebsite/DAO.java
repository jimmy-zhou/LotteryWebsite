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

	public Player get(int player_id) {
		EntityManager em = emf.createEntityManager();
		Player returned_player = em.find(Player.class, player_id);
		em.close();
		return returned_player;
	}

}
