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
		System.out.println(action); 
		if("list".equals(action)) {
			System.out.println("리스트 넘어감");
			path = list(request, response); 
			forward(request, response, path); 
		}else if("mvAdd".equals(action)){
			path ="/board/add.jsp";
			forward(request, response, path); 
		}else if("add".equals(action)) {
			System.out.println("add"); 
			path = add(request, response); 
			redirect(request, response, path); 
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
	
	
	static String add(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Add");
		BoardDto boardDto = new BoardDto(); 
		boardDto.setContent(request.getParameter("content"));
		boardDto.setSubject(request.getParameter("subject"));
		
		
		boardService.registerArticle(boardDto);
		
		
		return "/board?action=list";
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
