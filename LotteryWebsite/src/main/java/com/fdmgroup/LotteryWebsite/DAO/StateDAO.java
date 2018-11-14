package com.fdmgroup.LotteryWebsite.DAO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.LotteryWebsite.entities.State;

public class StateDAO {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void addState(State s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(s);
		et.commit();
		em.close();
	}
	
	public State getState(String stateName) {
		EntityManager em = emf.createEntityManager();
		State returnedState = em.find(State.class, stateName);
		em.close();
		return returnedState;
	}
}
