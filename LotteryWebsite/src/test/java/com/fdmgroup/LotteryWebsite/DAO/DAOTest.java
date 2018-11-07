package com.fdmgroup.LotteryWebsite.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.LotteryWebsite.DAO.DAO;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

public class DAOTest {

	@Test
	public void adding_player_persists_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Player mockPlayer = mock(Player.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<Player> playerDAO = new DAO<Player>(mockEmf);
		playerDAO.add(mockPlayer);

		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockPlayer);
		verify(mockEt).commit();
		verify(mockEm).close();

	}

	@Test
	public void adding_state_persists_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		State mockState = mock(State.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<State> stateDAO = new DAO<State>(mockEmf);
		stateDAO.add(mockState);

		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockState);
		verify(mockEt).commit();
		verify(mockEm).close();

	}

	@Test
	public void getting_player_retrieves_player_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<Player> playerDAO = new DAO<Player>(mockEmf);
		playerDAO.getPlayer("jimmy66666");

		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Player.class, "jimmy66666");
		order.verify(mockEm).close();

	}

}
