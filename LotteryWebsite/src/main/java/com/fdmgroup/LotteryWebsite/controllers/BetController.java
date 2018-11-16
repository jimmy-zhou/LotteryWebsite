package com.fdmgroup.LotteryWebsite.controllers;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.LotteryWebsite.DAO.BetDAO;
import com.fdmgroup.LotteryWebsite.entities.Bet;

@Controller
@RequestMapping(value = "/bet")
public class BetController {

	@Resource(name = "betDAOBean")
	private BetDAO betDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String goToBet(Model model) {
		model.addAttribute("myBet", new Bet());
		return "bet";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String makeBet(@ModelAttribute(value = "mybet") Bet bet, Model model) {
		model.addAttribute("main", pickMainNumber());
		model.addAttribute("powerball", pickPowerBallNumber());
		model.addAttribute("prize", Integer.MAX_VALUE);
		model.addAttribute("pick", bet.getPowerballNumber());
		return "bet";
	}

	public String pickMainNumber() {
		String main = new String();
		int[] pick = new int[5];
		Random rand = new Random();
		pick[0] = rand.nextInt(69) + 1;
		for (int i = 1; i < 5; i++) {
			int randInt = rand.nextInt(69) + 1;
			for (int j = 0; j < i; j++) {
				if (randInt == pick[j]) {
					randInt = rand.nextInt(69) + 1;
				}
				pick[i] = randInt;
			}
		}
		for (int i = 0; i < 5; i++) {
			main += pick[i] + " ";
		}
		return main;
	}

	public int pickPowerBallNumber() {
		Random rand = new Random();
		return rand.nextInt(26) + 1;
	}
}
