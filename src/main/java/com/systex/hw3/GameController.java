package com.systex.hw3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Servlet implementation class GameController
 */
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		GuessGame game = new GuessGame(10, 3);
		HttpSession session = request.getSession();
	    session.setAttribute("game", game);
	    response.sendRedirect("guess.jsp");
	}
		
	private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view;
		LinkedList<String> errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		
		String numberString = request.getParameter("number"); 
		
		if(numberString == null || numberString.trim().isEmpty()) {
			errorMsgs.add("必須填寫！");
		}
		if(numberString != null && !isInteger(numberString)) {
			errorMsgs.add("必須輸入整數");
        }
		if(!errorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("guess.jsp");
			view.forward(request, response);
			return;
		}
		
		int number = Integer.parseInt(numberString);
		HttpSession session = request.getSession();
		GuessGame game = (GuessGame) session.getAttribute("game");
		boolean success = game.guess(number);
		
		if (success) {
            session.invalidate();
            response.sendRedirect("youWin.jsp");
        } else if (game.getRemains() > 0) {
            request.setAttribute("remain", game.getRemains());
            request.getRequestDispatcher("guess.jsp").forward(request, response);
        } else {
            session.invalidate();
            request.getRequestDispatcher("youLose.jsp").forward(request, response);
        }
		
	}

}
