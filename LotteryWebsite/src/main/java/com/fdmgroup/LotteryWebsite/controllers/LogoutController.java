package com.fdmgroup.LotteryWebsite.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fdmgroup.LotteryWebsite.DAO.PlayerDAO;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

	@Resource(name = "playerDAOBean")
	private PlayerDAO playerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String goToLogout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
