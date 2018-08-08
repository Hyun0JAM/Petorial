package com.hy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hy.dao.LikeDAO;
import com.hy.dto.UserDTO;

/**
 * Servlet implementation class LIkePushServlet
 */
@WebServlet("/LikePushServlet")
public class LikePushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikePushServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");

		  // Session user�젙蹂� 遺덈윭�삤湲�
		  HttpSession session = request.getSession();
		  UserDTO user = new UserDTO();
		  user = (UserDTO) session.getAttribute("userinfo");
		  // tm_no
		  int tm_no = Integer.parseInt(request.getParameter("tm_no"));
		  LikeDAO likeDao = new LikeDAO();
		  if(likeDao.likeCheck(user.getId_no(), tm_no)) {
		    // 醫뗭븘�슂 痍⑥냼
			  
		    likeDao.likeOn(user.getId_no(), tm_no);
		  } else {
			  
		    // 醫뗭븘�슂
			  likeDao.likeOff(user.getId_no(), tm_no);
		  }
		  request.getRequestDispatcher("/loginsub.jsp").forward(request, response);
	}

}
