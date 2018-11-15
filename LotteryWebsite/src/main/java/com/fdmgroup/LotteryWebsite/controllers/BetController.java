package com.fdmgroup.LotteryWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.LotteryWebsite.entities.Bet;
import com.fdmgroup.LotteryWebsite.entities.Player;

@Controller
@SessionAttributes(value="loginPlayer")
@RequestMapping(value = "/bet")
public class BetController {

	@RequestMapping(method = RequestMethod.GET)
	public String goToBet(Model model) {
		model.addAttribute("myBet", new Bet());
		return "bet";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String print(@ModelAttribute(value="loginPlayer") Player player) {
		System.out.println(player.toString());
		System.out.println("MAKE SURE IT RUNS");
		return "bet";
	}
}
