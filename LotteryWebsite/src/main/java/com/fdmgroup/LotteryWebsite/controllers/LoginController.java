package com.fdmgroup.LotteryWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.LotteryWebsite.entities.Player;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String goToLogin(Model model) {
		model.addAttribute("loginPlayer", new Player());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginPlayer(Player p, Model model) {
		System.out.println(p);
		return "home";
	}

}
