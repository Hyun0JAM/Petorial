package com.hy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hy.dao.PhotoDAO;
import com.hy.dao.TagDAO;
import com.hy.dto.PhotoDTO;
import com.hy.dto.UserDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		// �씠誘몄� �뙆�씪�씠 �뾾�쓣�떆 由ы꽩
		/*if(multi.getFilesystemName("img")==null) {
			response.sendRedirect("timeline.jsp");
		}*/
		// �씠誘몄� �뙆�씪 ���옣�븯湲�
		// ���옣�맆 �씠誘몄� 二쇱냼
		String savePath = "/usr/share/tomcat8/webapps/Petorial/images";
		// �씠誘몄� �겕湲�
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		// �뙆�씪 �씠由� ���옣
		String fileName = multi.getFilesystemName("img");
		// DB�뿉 ���옣�맆 二쇱냼
		String fileFullPath = "images/"+ fileName;
		//String fileFullPath = savePath + "/"+ fileName;

		// Session�뿉 ���옣�맂 user媛앹껜 遺덈윭�삤湲�
		HttpSession session = request.getSession();
		UserDTO user = new UserDTO();
		user = (UserDTO) session.getAttribute("userinfo");
		// �뤌�뿉 �궡�슜�쑝濡� photo 媛앹껜 �깮�꽦
		PhotoDTO photo = new PhotoDTO();
		photo.setId_no(user.getId_no());
		photo.setTm_content(multi.getParameter("content"));
		photo.setTm_img(fileFullPath);
		photo.setTm_nick(user.getUser_nickname());
		photo.setTm_userimg(user.getUser_img());
		// DAO �꽑�뼵
		PhotoDAO photoDao = new PhotoDAO();
		TagDAO tagDao = new TagDAO();

		if(photoDao.writePhoto(photo)) {
			//session.setAttribute("photo", photoDao.getPhoto());
			// �엯�젰�븳  tag �굹�늻湲�
			String[] tags = multi.getParameter("tag").split(" ");
			for(String tag : tags) {
				if(tag.startsWith("#")) {
					// tag DB�뿉 insert
					tagDao.insert(photoDao.getTmno(), tag);
				}
			}
			request.getRequestDispatcher("/loginsub.jsp").forward(request, response);
		} else {
			response.sendRedirect("/err.jsp");
		}
	}
}
