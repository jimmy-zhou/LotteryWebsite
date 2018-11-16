package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.fdmgroup.LotteryWebsite.DAO.PlayerDAO;
import com.fdmgroup.LotteryWebsite.DAO.StateDAO;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

public class RegisterControllerTest {

	@Mock
	private PlayerDAO mockPlayerDAO;

	@Mock
	private StateDAO mockStateDAO;

	@Mock
	private Model mockModel;

	@Mock
	private HttpServletRequest mockReq;

	@Mock
	private Player mockPlayer;

	@InjectMocks
	private RegisterController rc = new RegisterController();

	@Before
	public void startInjectingMocks() {
		MockitoAnnotations.initMocks(this);
		when(mockPlayer.getUsername()).thenReturn("jimmy66666");
		when(mockPlayer.getPassword()).thenReturn("welcome12345");
		when(mockPlayer.getFirstName()).thenReturn("Jimmy");
		when(mockPlayer.getLastName()).thenReturn("Zhou");
	}

	@Test
	public void when_requestForRegister_then_returnRegisterJspName() {
		String nextPage = rc.goToRegister(mockModel);
		assertEquals("register", nextPage);
	}

	@Test
	public void when_RegisterUsernameIsDuplicated_then_returnRegisterJspName() {
		Player mockReturnedPlayer = mock(Player.class);
		State mockReturnedState = mock(State.class);
		when(mockPlayerDAO.getPlayer("jimmy66666")).thenReturn(mockReturnedPlayer);
		when(mockReq.getParameter("stateName")).thenReturn("FL");
		when(mockStateDAO.getState("FL")).thenReturn(mockReturnedState);
		String nextPage = null;
		try {
			nextPage = rc.validateRegister(mockPlayer, mockModel, mockReq);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("register", nextPage);
	}

	@Test
	public void when_RegisterIsInValid_then_returnErrorJspName() {
		State mockReturnedState = mock(State.class);
		when(mockPlayerDAO.getPlayer("jimmy66666")).thenReturn(null);
		when(mockReq.getParameter("stateName")).thenReturn("FL");
		when(mockStateDAO.getState("FL")).thenReturn(mockReturnedState);
		String nextPage = null;
		try {
			nextPage = rc.validateRegister(mockPlayer, mockModel, mockReq);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("error", nextPage);
	}

	@Test
	public void when_RegisterIsValid_then_returnLoginJspName() {
		State mockReturnedState = mock(State.class);
		when(mockPlayer.getCreditCard()).thenReturn("6011133813264481");
		when(mockPlayerDAO.getPlayer("jimmy66666")).thenReturn(null);
		when(mockReq.getParameter("stateName")).thenReturn("FL");
		when(mockStateDAO.getState("FL")).thenReturn(mockReturnedState);
		String nextPage = null;
		try {
			nextPage = rc.validateRegister(mockPlayer, mockModel, mockReq);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("login", nextPage);
	}
}
