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

/**
 * Servlet implementation class TimelineServlet
 */
@WebServlet("/TimelineServlet")
public class TimelineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimelineServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// DAO �꽑�뼵
	  PhotoDAO photoDao = new PhotoDAO();
	  CommentsDAO commentsDao = new CommentsDAO();
	  TagDAO tagDao = new TagDAO();
		LikeDAO likeDao = new LikeDAO();
		// photo 媛앹껜 �깮�꽦
	  List<PhotoDTO> photo = new ArrayList<PhotoDTO>();
		// �깭洹� 寃��깋�떆 �빐�떦 photo 媛앹껜
	  /*if(request.getParameter("tag")!=null) {
		  photo = photoDao.getSearchPhoto(request.getParameter("tag"));
	  }*/ 
	  if(request.getParameter("search")==null || request.getParameter("search").equals("")) {
	  	photo = photoDao.getPhoto();
	  } else {
	  	photo = photoDao.getSearchPhoto(request.getParameter("search"));
	  }
		
	  // photo媛앹껜�뿉 comment, tag, like 媛앹껜 ���옣
	  for(int i=0; i<photo.size(); i++) {
	  	photo.get(i).setComments(commentsDao.getComments(photo.get(i).getTm_no()));
	   	photo.get(i).setTags(tagDao.getTag(photo.get(i).getTm_no()));
			// 寃뚯떆臾� 醫뗭븘�슂�븳 �쑀��紐⑸줉 �꽔湲�
			// 醫뗭븘�슂 �닔�뒗 size濡�
			photo.get(i).setLikes(likeDao.getLikeOnList(photo.get(i).getTm_no()));
	  }
	  		// request�뿉 photo媛앹껜 �떞湲�
		request.setAttribute("photo", photo);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
}
