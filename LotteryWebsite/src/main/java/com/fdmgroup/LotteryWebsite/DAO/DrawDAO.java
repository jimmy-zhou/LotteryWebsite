package com.fdmgroup.LotteryWebsite.DAO;

import java.sql.Date;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.LotteryWebsite.entities.Draw;

public class DrawDAO {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void addDraw(Draw d) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(d);
		et.commit();
		em.close();
	}

	public Draw getDraw(Date drawDate) {
		EntityManager em = emf.createEntityManager();
		Draw returnedDraw = em.find(Draw.class, drawDate);
		em.close();
		return returnedDraw;
	}
}
