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
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("lotteryWebsite");
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
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String stateName = req.getParameter("stateName");
		String creditCard = req.getParameter("creditCard");

		req.setAttribute("errorMsg", "This username has existed, please enter a new one");

		Player p = playerDAO.getPlayer(username);
		State s = stateDAO.getState(stateName);
		RequestDispatcher rd = null;
		if (p != null) {
			rd = req.getRequestDispatcher("register.jsp");
		} else if (username.contains("<") || username.length() < 3 || password.length() < 6 || firstName.length() == 0
				|| lastName.length() == 0 || !luhnCheck(creditCard)) {
			rd = req.getRequestDispatcher("error.jsp");
		} else {
			p = new Player(username, s, firstName, lastName, password, creditCard);
			playerDAO.add(p);
			rd = req.getRequestDispatcher("login.jsp");
		}
		rd.forward(req, resp);
	}

	// An algorithm to check the credit card details are valid
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
