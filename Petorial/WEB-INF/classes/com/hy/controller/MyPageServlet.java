package com.hy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hy.dao.CommentsDAO;
import com.hy.dao.LikeDAO;
import com.hy.dao.PhotoDAO;
import com.hy.dao.TagDAO;
import com.hy.dto.PhotoDTO;
import com.hy.dto.UserDTO;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
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
		  // user id媛��졇�삤湲�
		  // id_no = Integer.parseInt(request.getParameter("id_no"));
		  // UserDAO userDao = new UserDAO();
		  // user = userDao.userInfoWithId(id_no);
		  List<PhotoDTO> photo = new ArrayList<PhotoDTO>();
		  PhotoDAO photoDao = new PhotoDAO();
		  CommentsDAO commentsDao = new CommentsDAO();
		  TagDAO tagDao = new TagDAO();
		  LikeDAO likeDao = new LikeDAO();
		  System.out.println(user.getId_no());
		  photo = photoDao.getUserPhoto(user.getId_no());

		  // photo媛앹껜�뿉 comment, tag, like 媛앹껜 ���옣
		  for(int i=0; i<photo.size(); i++) {
		    photo.get(i).setComments(commentsDao.getComments(photo.get(i).getTm_no()));
		    photo.get(i).setTags(tagDao.getTag(photo.get(i).getTm_no()));
		    // 寃뚯떆臾� 醫뗭븘�슂�븳 �쑀��紐⑸줉 �꽔湲�
		    // 醫뗭븘�슂 �닔�뒗 size濡�
		    photo.get(i).setLikes(likeDao.getLikeOnList(photo.get(i).getTm_no()));
		  }
		  
		  // request�뿉 photo媛앹껜 �떞湲�
		  request.setAttribute("user", user);
		  request.setAttribute("photo", photo);
		  request.getRequestDispatcher("/MyPage.jsp").forward(request, response);
	}

}
