package com.fdmgroup.LotteryWebsite.DAO;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.LotteryWebsite.entities.Draw;

public class DrawDAOTest {

	@Mock
	private EntityManagerFactory mockEmf;

	@Mock
	private EntityManager mockEm;

	@Mock
	private EntityTransaction mockEt;

	@InjectMocks
	private DrawDAO drawDAO = new DrawDAO();

	@Before
	public void startInjectingMocks() {
		MockitoAnnotations.initMocks(this);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
	}

	@Test
	public void getEmfTest() {
		EntityManagerFactory injectedEmf = drawDAO.getEmf();
		assertEquals(mockEmf, injectedEmf);
	}

	@Test
	public void adding_draw_persists_and_cleans_up_resources() {
		Draw mockDraw = mock(Draw.class);
		drawDAO.addDraw(mockDraw);
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockDraw);
		verify(mockEt).commit();
		verify(mockEm).close();
	}

	@Test
	public void getting_draw_retrieves_draw_and_cleans_up_resources() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 10, 03);
		Date date = new Date(calendar.getTime().getTime());
		drawDAO.getDraw(date);
		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Draw.class, date);
		order.verify(mockEm).close();
	}
}
