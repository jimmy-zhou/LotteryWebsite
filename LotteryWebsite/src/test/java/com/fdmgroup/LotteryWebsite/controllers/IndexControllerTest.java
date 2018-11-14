package com.fdmgroup.LotteryWebsite.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fdmgroup.LotteryWebsite.controllers.IndexController;

public class IndexControllerTest {

	@Test
	public void when_requestForIndexResource_then_returnIndexJspName() {
		
		IndexController ic = new IndexController();
		String nextPage = ic.goToIndex();
		
		assertEquals("index", nextPage);
	}
}
