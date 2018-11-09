package com.fdmgroup.LotteryWebsite.servlets;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdmgroup.LotteryWebsite.DAO.DAO;
import com.fdmgroup.LotteryWebsite.entities.Player;
import com.fdmgroup.LotteryWebsite.entities.State;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 2463284093313078884L;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("lotteryWebsite");
	DAO<Player> playerDAO = new DAO<Player>(emf);
	DAO<State> stateDAO = new DAO<State>(emf);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String state_name = req.getParameter("state_name");
		String credit_card = req.getParameter("credit_card");

		req.setAttribute("error_msg", "This username has existed, please enter a new one");

		Player p = playerDAO.getPlayer(username);
		State s = stateDAO.getState(state_name);
		RequestDispatcher rd = null;
		if (p != null) {
			rd = req.getRequestDispatcher("register.jsp");
		} else if (username.length() < 3 || password.length() < 6 || 
				first_name.length() == 0 || last_name.length() == 0 || 
				! luhnCheck(credit_card)) {
			rd = req.getRequestDispatcher("error.jsp");
		} else {
			p = new Player(username, s, first_name, last_name, password, credit_card);
			playerDAO.add(p);
			rd = req.getRequestDispatcher("login.jsp");
		}
		rd.forward(req, resp);
	}

	public static boolean luhnCheck(String credit_card) {
		if (credit_card == null || credit_card.length() == 0)
			return false;
		char checkDigit = credit_card.charAt(credit_card.length() - 1);
		String digit = calculateCheckDigit(credit_card.substring(0, credit_card.length() - 1));
		return checkDigit == digit.charAt(0);
	}

	public static String calculateCheckDigit(String credit_card) {
		if (credit_card == null)
			return null;
		String digit;

		int[] digits = new int[credit_card.length()];
		for (int i = 0; i < credit_card.length(); i++) {
			digits[i] = Character.getNumericValue(credit_card.charAt(i));
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
