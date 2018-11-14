package com.fdmgroup.LotteryWebsite.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.LotteryWebsite.DAO.DAO;
import com.fdmgroup.LotteryWebsite.entities.Bet;
import com.fdmgroup.LotteryWebsite.entities.Draw;
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
	public void adding_bet_persists_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Bet mockBet = mock(Bet.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<Bet> betDAO = new DAO<Bet>(mockEmf);
		betDAO.add(mockBet);

		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockBet);
		verify(mockEt).commit();
		verify(mockEm).close();

	}

	@Test
	public void adding_draw_persists_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Draw mockDraw = mock(Draw.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<Draw> drawDAO = new DAO<Draw>(mockEmf);
		drawDAO.add(mockDraw);

		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockDraw);
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

	@Test
	public void getting_state_retrieves_state_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<State> stateDAO = new DAO<State>(mockEmf);
		stateDAO.getState("NY");

		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(State.class, "NY");
		order.verify(mockEm).close();

	}

	@Test
	public void getting_bet_retrieves_bet_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		DAO<Bet> betDAO = new DAO<Bet>(mockEmf);
		betDAO.getBet(100);

		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Bet.class, 100);
		order.verify(mockEm).close();

	}

	@Test
	public void getting_draw_retrieves_draw_and_cleans_up_resources() {
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);

		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 10, 03);
		Date date = new Date(calendar.getTime().getTime());

		DAO<Draw> drawDAO = new DAO<Draw>(mockEmf);
		drawDAO.getDraw(date);

		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Draw.class, date);
		order.verify(mockEm).close();
	}
}
