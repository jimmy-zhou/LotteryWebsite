package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fdmgroup.LotteryWebsite.DAO.PlayerDAO;

public class LogoutControllerTest {
	@Mock
	private PlayerDAO playerDAO;

	@InjectMocks
	private LogoutController lc = new LogoutController();

	@Before
	public void startInjectMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void return_GoToLogout() {
		HttpSession mockSession = mock(HttpSession.class);
		String nextPage = lc.goToLogout(mockSession);
		assertEquals("logout", nextPage);
	}

}
