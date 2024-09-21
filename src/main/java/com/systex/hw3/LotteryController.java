package com.systex.hw3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/**
 * Servlet implementation class LotterysController
 */
public class LotteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LotteryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher view;
		LinkedList<String> errorMsgs = new LinkedList<>();
		request.setAttribute("errors", errorMsgs);
		
		String group = request.getParameter("group");
		String exclude = request.getParameter("exclude");
		
		if(group == null || group.trim().isEmpty()) {
			errorMsgs.add("組數欄位必須填寫");
		}
		if(group != null && !isInteger(group)) {
			errorMsgs.add("組數位必須是整數");
        }
		if(exclude == null || exclude.trim().isEmpty()) {
			exclude = " ";
		}
		if(!errorMsgs.isEmpty()) {
			view = request.getRequestDispatcher("main.jsp");
			view.forward(request, response);
			return;
		}
		
		int groupNum = Integer.parseInt(group);
		
		String[]arrayExclude = exclude.split(" ");
		LinkedList<String> linkedExclude = new LinkedList<>(Arrays.asList(arrayExclude));

				
		try {
			LotteryService lot = new LotteryService();
			lot.setGroup(groupNum);
			lot.setExclude(exclude);
			ArrayList<LinkedList<String>> resultArray = lot.getNumbers(groupNum,linkedExclude);
			
			lot.setResult(resultArray);
			
			request.setAttribute("lot", lot);
			
			view = request.getRequestDispatcher("result.jsp");
			view.forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				errorMsgs.add(e.getMessage());
				view = request.getRequestDispatcher("main.jsp");
				view.forward(request, response);
				}
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
		doGet(request, response);
	}

}
