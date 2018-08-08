package com.hy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hy.dao.UserDAO;
import com.hy.dto.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
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

		UserDAO dao = new UserDAO();
	  /*// EMAIL 以묐났泥댄겕
	  if(dao.emailCheck(user)) {
	  	request.getRequestDispatcher("/login.jsp").forward(request, response);
	  }*/
		// �씠誘몄� �뙆�씪 ���옣�븯湲�
		// ���옣�맆 �씠誘몄� 二쇱냼
		String savePath = "/usr/share/tomcat8/webapps/Petorial/images";/*"C:/Users/Bogass/eclipse-workspace/Petorial/WebContent/images*/
		// �씠誘몄� �겕湲�
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		// �뙆�씪 �씠由� ���옣
		String fileName = "";
		if(multi.getFilesystemName("image")!=null) {
			fileName = multi.getFilesystemName("image");
		} else {
			fileName = "user.png";
		}
		// DB�뿉 ���옣�맆 二쇱냼
		String fileFullPath = "images/"+ fileName;
		//String fileFullPath = savePath + "/"+ fileName;

		// �쉶�썝媛��엯 �뤌�뿉 �엯�젰�븳 �궡�슜�쑝濡� 媛앹껜留뚮뱾湲�
	  UserDTO user = new UserDTO();
	  user.setUser_email(multi.getParameter("email"));
	  user.setUser_pw(multi.getParameter("pw"));
	  user.setUser_img(fileFullPath);
	  user.setUser_nickname(multi.getParameter("nickname"));
	  user.setUser_birth(Integer.parseInt(multi.getParameter("birth")));

		// �쉶�썝媛��엯
		if(dao.setUserInfo(user)){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{ // 媛��엯�떎�뙣
		  response.sendRedirect("/login.jsp");
		}
	}
}
