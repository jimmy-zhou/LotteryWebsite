package com.fdmgroup.LotteryWebsite.DAO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.LotteryWebsite.entities.Player;

public class PlayerDAO {

	@Resource(name = "emfBean")
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void addPlayer(Player p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(p);
		et.commit();
		em.close();
	}

	public Player getPlayer(String username) {
		EntityManager em = emf.createEntityManager();
		Player returnedPlayer = em.find(Player.class, username);
		em.close();
		return returnedPlayer;
	}
}
