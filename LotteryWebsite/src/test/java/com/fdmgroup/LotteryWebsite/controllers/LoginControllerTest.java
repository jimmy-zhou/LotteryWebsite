package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.LotteryWebsite.controllers.LoginController;
import com.fdmgroup.LotteryWebsite.entities.Player;

public class LoginControllerTest {

	@Test
	public void when_requestForLogin_then_returnLoginJspName() {
		LoginController lc = new LoginController();
		Model mockModel = mock(Model.class);
		String nextPage = lc.goToLogin(mockModel);
		assertEquals("login", nextPage);
	}

	@Test
	public void when_loginIsValid_then_returnHomeJspName() {
		LoginController lc = new LoginController();
		Model mockModel = mock(Model.class);
		Player player = new Player();
		String nextPage = lc.validateLogin(player, mockModel);
		assertEquals("home", nextPage);
	}
	/*
	 * @Test public void when_loginIsInValid_then_returnBlockJspName() {
	 * LoginController lc = new LoginController(); Model model =
	 * Mockito.mock(Model.class); String nextPage = lc.goToLogin(model);
	 * assertEquals("block", nextPage); }
	 */
}
