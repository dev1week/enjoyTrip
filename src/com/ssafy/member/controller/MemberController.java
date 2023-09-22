package com.ssafy.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    static MemberService memberService = MemberServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		
		if("mvJoin".equals(action)) {
			path = mvJoin(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}else if("join".equals(action)) {
			join(request,response);
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath() + path);
	}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	static String mvJoin(HttpServletRequest request, HttpServletResponse response) {
		return "/user/join.jsp";
	}
	
	static String join(HttpServletRequest request, HttpServletResponse response) {
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(request.getParameter("userId"));
		memberDto.setUserPass(request.getParameter("userPw"));
		memberDto.setUserName(request.getParameter("userName"));
		memberDto.setUserEmail(request.getParameter("userEmail"));

		memberService.registerMember(memberDto);
		return "/join.jsp";
	}
}
