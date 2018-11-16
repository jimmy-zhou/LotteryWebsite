package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.LotteryWebsite.entities.Bet;

public class BetControllerTest {
	
	@Test
	public void when_requestForBet_then_returnBetJspName() {
		BetController bc = new BetController();
		Model mockModel = mock(Model.class);
		String nextPage = bc.goToBet(mockModel);
		assertEquals("bet", nextPage);
	}

	@Test
	public void when_BetIsValid_then_returnBetJspName() {
		BetController bc = new BetController();
		Model mockModel = mock(Model.class);
		Bet bet = new Bet();
		String nextPage = bc.makeBet(bet, mockModel);
		assertEquals("bet", nextPage);
	}

}
