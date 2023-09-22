package com.ssafy.board.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static BoardService boardService; 
	
	
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		boardService = BoardServiceImpl.getBoardService(); 
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); 
		
		String path = ""; 
		
		if(action.equals("list")) {
			path = list(request, response); 
			forward(request, response, path); 
		}else if(action.equals("mvAdd")){
			path ="/board/add.jsp";
			forward(request, response, path); 
		}
		
		
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher(path); 
		dispatcher.forward(request, response); 
	}
	
	
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(path);	
	}
	
	
	static String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			ArrayList<BoardDto> list = (ArrayList<BoardDto>) boardService.searchListAll(); 
			request.setAttribute("articles", list); 		
			return "/board/list.jsp"; 
		}catch(Exception e) {
			
			return "/error/error.jsp"; 
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
