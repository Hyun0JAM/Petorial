package com.hy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hy.dao.CommentsDAO;
import com.hy.dao.PhotoDAO;
import com.hy.dao.UserDAO;
import com.hy.dto.PhotoDTO;
import com.hy.dto.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 로그인 입력 정보로 DTO 객체 생성
		UserDTO user = new UserDTO();
		user.setUser_email(request.getParameter("email"));
	  user.setUser_pw(request.getParameter("pw"));

		// 쿠키 정보 생성
	  String chk = request.getParameter("remember");
		Cookie cookie = null;
	  if(chk != null && chk.trim().equals("on")) {
	  	cookie = new Cookie("cid",user.getUser_email());
	  	cookie.setMaxAge(60*60*24*365);
	    response.addCookie(cookie);
	  } else {
	    cookie = new Cookie("cid",null);
	    cookie.setMaxAge(0);
	    response.addCookie(cookie);
	  }

		// DAO 선언 후 로그인 시도
		UserDAO dao = new UserDAO();
    switch(dao.loginCheck(user)) {
	  case "DONE": // 로그인 성공
			HttpSession session = request.getSession();
			// DB정보를 불러와서 user객체에 저장
	  	user = dao.getUserInfo(user);
			// Session에 정보 저장하기
	    session.setAttribute("userinfo", user);
	    session.setAttribute("userid", user.getUser_nickname());
	    request.getRequestDispatcher("/loginsub.jsp").forward(request, response);
	    break;
	  case "WRONG PASSWORD":
	    response.sendRedirect("/Petorial/login.jsp");
	    break;
	  case "NO EMAIL": 
	    response.sendRedirect("/Petorial/login.jsp");
	    break;
	  }
	}
}
