package com.fdmgroup.LotteryWebsite.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.LotteryWebsite.DAO.PlayerDAO;
import com.fdmgroup.LotteryWebsite.DAO.StateDAO;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

@Controller
@SessionAttributes(value = "loginPlayer")
@RequestMapping(value = "/register")
public class RegisterController {

	@Resource(name = "playerDAOBean")
	private PlayerDAO playerDAO;

	@Resource(name = "stateDAOBean")
	private StateDAO stateDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String goToRegister(Model model) {
		model.addAttribute("registerPlayer", new Player());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validateRegister(@ModelAttribute(value = "registerPlayer") Player player, Model model,
			HttpServletRequest req) throws ServletException, IOException {
		Player foundPlayer = playerDAO.getPlayer(player.getUsername());
		String stateName = req.getParameter("stateName");
		State returnedState = stateDAO.getState(stateName);

		if (foundPlayer != null) {
			model.addAttribute("errorMsg", "This username has existed, please enter a new one");
			return "register";
		} else if (player.getUsername().contains("<") || player.getUsername().length() < 3
				|| player.getPassword().length() < 6 || player.getFirstName().length() == 0
				|| player.getLastName().length() == 0 || !luhnCheck(player.getCreditCard())) {
			return "error";
		} else {
			foundPlayer = new Player(player.getUsername(), returnedState, player.getFirstName(), player.getLastName(),
					player.getPassword(), player.getCreditCard());
			playerDAO.addPlayer(foundPlayer);
			model.addAttribute("loginPlayer", player);
			model.addAttribute("successMsg", "You have successfully registered, now please login");
			return "login";
		}
	}

	// An algorithm to check if the credit card details are valid
	public static boolean luhnCheck(String creditCard) {
		if (creditCard == null || creditCard.length() == 0)
			return false;
		char checkDigit = creditCard.charAt(creditCard.length() - 1);
		String digit = calculateCheckDigit(creditCard.substring(0, creditCard.length() - 1));
		return checkDigit == digit.charAt(0);
	}

	public static String calculateCheckDigit(String creditCard) {
		if (creditCard == null)
			return null;
		String digit;
		int[] digits = new int[creditCard.length()];
		for (int i = 0; i < creditCard.length(); i++) {
			digits[i] = Character.getNumericValue(creditCard.charAt(i));
		}
		for (int i = digits.length - 1; i >= 0; i -= 2) {
			digits[i] += digits[i];
			if (digits[i] >= 10) {
				digits[i] = digits[i] - 9;
			}
		}
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
		}
		sum = sum * 9;
		digit = sum + "";
		return digit.substring(digit.length() - 1);
	}
}
