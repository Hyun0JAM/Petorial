package com.hy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hy.dao.CommentsDAO;
import com.hy.dto.CommentsDTO;
import com.hy.dto.UserDTO;

/**
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/CommentsServlet")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsServlet() {
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
		// 댓글 쓰기
		// Session에 저장된 user불러오기
		HttpSession session = request.getSession();
		UserDTO user = new UserDTO();
		user = (UserDTO)session.getAttribute("userinfo");
		// Comment객체 생성
		CommentsDTO comments = new CommentsDTO();
		comments.setCm_text(request.getParameter("comment"));
		// 게시물 번호
		int tmid =Integer.parseInt(request.getParameter("tm_no"));
		// 댓글생성
		CommentsDAO commentsDao = new CommentsDAO();
		if(commentsDao.insertComments(user, tmid, comments)) {
			// TimelineServlet으로
			request.getRequestDispatcher("/mainSub.jsp").forward(request, response);
		} else {
			response.sendRedirect("/err.jsp");
		}
	}
}
