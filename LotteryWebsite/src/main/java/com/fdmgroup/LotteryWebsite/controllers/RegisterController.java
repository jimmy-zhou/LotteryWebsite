package com.fdmgroup.LotteryWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.LotteryWebsite.entities.Player;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

	@RequestMapping(method=RequestMethod.GET)
	public String goToRegister(Model model) {
		model.addAttribute("registerPlayer", new Player());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registerPlayer(Model model, Player p) {
		model.addAttribute("loginPlayer", new Player());
		System.out.println(p);
		return "login";
	}

}
