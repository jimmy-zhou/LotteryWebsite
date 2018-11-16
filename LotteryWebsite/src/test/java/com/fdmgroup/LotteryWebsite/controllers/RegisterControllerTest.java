package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.LotteryWebsite.entities.Player;

public class RegisterControllerTest {

	@Test
	public void when_requestForRegister_then_returnRegisterJspName() {
		RegisterController rc = new RegisterController();
		Model mockModel = mock(Model.class);
		String nextPage = rc.goToRegister(mockModel);
		assertEquals("register", nextPage);
	}

	@Test
	public void when_RegisterIsValid_then_returnLoginJspName() {
		RegisterController rc = new RegisterController();
		Model mockModel = mock(Model.class);
		HttpServletRequest mockReq = mock(HttpServletRequest.class);
		Player player = new Player();
		player.setUsername("jimmy66666");
		String nextPage = "login";
		try {
			nextPage = rc.validateRegister(player, mockModel, mockReq);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		assertEquals("login", nextPage);
	}

	@Test
	public void when_RegisterIsInValid_then_returnErrorJspName() {
		RegisterController rc = new RegisterController();
		Model mockModel = mock(Model.class);
		HttpServletRequest mockReq = mock(HttpServletRequest.class);
		Player player = new Player();
		String nextPage = "error";
		try {
			nextPage = rc.validateRegister(player, mockModel, mockReq);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		assertEquals("error", nextPage);
	}

	@Test
	public void when_RegisterIsDuplicated_then_returnRegisterJspName() {
		RegisterController rc = new RegisterController();
		Model mockModel = mock(Model.class);
		HttpServletRequest mockReq = mock(HttpServletRequest.class);
		Player player = new Player();
		String nextPage = "register";
		try {
			nextPage = rc.validateRegister(player, mockModel, mockReq);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException ne) {
			ne.printStackTrace();
		}
		assertEquals("register", nextPage);
	}
}
