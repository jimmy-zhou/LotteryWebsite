package com.fdmgroup.LotteryWebsite.DAO;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.LotteryWebsite.entities.Bet;
import com.fdmgroup.LotteryWebsite.entities.Draw;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

public abstract class GenericDAO<T> {

	private EntityManagerFactory emf;

	public GenericDAO(EntityManagerFactory emf) {
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

	public abstract T getT(String string);

}
