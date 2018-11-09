package com.fdmgroup.LotteryWebsite.servlets;

import javax.servlet.http.HttpServlet;

//import java.io.IOException;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fdmgroup.LotteryWebsite.DAO.DAO;
//import com.fdmgroup.LotteryWebsite.entities.Bet;
//import com.fdmgroup.LotteryWebsite.entities.Player;

public class BetServlet extends HttpServlet {

	
	private static final long serialVersionUID = 8350801924409383071L;
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("lotteryWebsite");
//	DAO<Player> playerDAO = new DAO<Player>(emf);
//	DAO<Bet> betDAO = new DAO<Bet>(emf);
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher rd = req.getRequestDispatcher("bet.jsp");
//		rd.forward(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String first_num = req.getParameter("first_num");
//		String second_num = req.getParameter("second_num");
//		String third_num = req.getParameter("third_num");
//		String fourth_num = req.getParameter("fourth_num");
//		String fifth_num = req.getParameter("fifth_num");
//		String powerball_num = req.getParameter("powerball_num");
//
//		req.setAttribute("error_msg", "This bet has been chosen, please select a new one");
//		
//		RequestDispatcher rd = null;
//		Bet b = new Bet();
//		betDAO.add(b);
//		rd.forward(req, resp);
//	}
}
