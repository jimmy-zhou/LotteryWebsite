package com.fdmgroup.LotteryWebsite.controllers;

import java.util.Random;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.LotteryWebsite.DAO.PlayerDAO;
import com.fdmgroup.LotteryWebsite.entities.Player;

@Controller
@SessionAttributes(value="loginPlayer")
@RequestMapping(value = "/login")
public class LoginController {
	
	@Resource(name="playerDAOBean")
	private PlayerDAO playerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String goToLogin(Model model) {
		model.addAttribute("loginPlayer", new Player());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validateLogin(@ModelAttribute(value="loginPlayer") Player player, Model model) {
		model.addAttribute("luckyNumber", new Random().nextInt(26) + 1);
		Player foundPlayer = playerDAO.getPlayer(player.getUsername());
		if (foundPlayer != null && foundPlayer.getPassword().equals(player.getPassword())) {
			model.addAttribute("activeUser", player.getUsername());
			return "home";
		} else {
			return "block";
		}
	}
}
