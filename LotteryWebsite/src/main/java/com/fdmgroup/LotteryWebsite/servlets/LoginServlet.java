package com.fdmgroup.LotteryWebsite.servlets;

import java.io.IOException;
import java.util.Random;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.LotteryWebsite.DAO.DAO;
import com.fdmgroup.LotteryWebsite.entities.Player;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1314163141578396190L;

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("lotteryWebsite");
	DAO<Player> playerDAO = new DAO<Player>(emf);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		req.setAttribute("lucky_number", new Random().nextInt(26) + 1);

		Player p = playerDAO.getPlayer(username);
		RequestDispatcher rd = null;
		if (p != null && p.getPassword().equals(password)) {
			rd = req.getRequestDispatcher("home.jsp");
			HttpSession session = req.getSession();
			session.setAttribute("active_user", username);
		} else {
			rd = req.getRequestDispatcher("block.jsp");
		}
		rd.forward(req, resp);
	}
}