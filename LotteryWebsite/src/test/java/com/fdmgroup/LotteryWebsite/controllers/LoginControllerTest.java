package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.fdmgroup.LotteryWebsite.DAO.PlayerDAO;
import com.fdmgroup.LotteryWebsite.controllers.LoginController;
import com.fdmgroup.LotteryWebsite.entities.Player;

public class LoginControllerTest {

	@Mock
	private PlayerDAO mockPlayerDAO;

	@Mock
	private Model mockModel;

	@Mock
	private Player mockPlayer;

	@InjectMocks
	private LoginController lc = new LoginController();

	@Before
	public void startInjectingMocks() {
		MockitoAnnotations.initMocks(this);
		when(mockPlayer.getUsername()).thenReturn("jimmy66666");
		when(mockPlayer.getPassword()).thenReturn("welcome12345");
	}

	@Test
	public void when_requestForLogin_then_returnLoginJspName() {
		String nextPage = lc.goToLogin(mockModel);
		assertEquals("login", nextPage);
	}

	@Test
	public void when_loginIsValid_then_returnHomeJspName() {
		Player mockReturnedPlayer = mock(Player.class);
		when(mockPlayerDAO.getPlayer("jimmy66666")).thenReturn(mockReturnedPlayer);
		when(mockReturnedPlayer.getPassword()).thenReturn("welcome12345");
		String nextPage = lc.validateLogin(mockPlayer, mockModel);
		assertEquals("home", nextPage);
	}

	@Test
	public void when_loginIsInValid_then_returnBlockJspName() {
		Player mockReturnedPlayer = mock(Player.class);
		when(mockPlayerDAO.getPlayer("jimmy66666")).thenReturn(mockReturnedPlayer);
		when(mockReturnedPlayer.getPassword()).thenReturn("wrongPassword");
		String nextPage = lc.validateLogin(mockPlayer, mockModel);
		assertEquals("block", nextPage);
	}

}
