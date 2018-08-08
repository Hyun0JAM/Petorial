package com.hy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hy.dto.CommentsDTO;
import com.hy.dto.UserDTO;

public class CommentsDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;

	// 해당게시물 댓글 불러오기
	public List<CommentsDTO> getComments(int tmid) {
		String sql = "SELECT * FROM comments WHERE tm_no=?";
		List<CommentsDTO> list = null;
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setInt(1, tmid);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				CommentsDTO comments = new CommentsDTO();
				comments.setCm_no(rs.getInt("cm_no"));
				comments.setCm_nick(rs.getString("cm_nick"));
				comments.setCm_text(rs.getString("cm_text"));
				comments.setCm_date(rs.getDate("cm_date"));
				comments.setId_no(rs.getInt("id_no"));
				comments.setTm_no(rs.getInt("tm_no"));
				list.add(comments);
			}
		} catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
		return list;
	}

	// 댓글쓰기
	public boolean insertComments(UserDTO user, int tmid, CommentsDTO comments) {
		String sql = "INSERT INTO comments(cm_nick,cm_text,id_no,cm_date,tm_no) VALUES(?,?,?,NOW(),?)";
		int i = 0;
	      try {
	         pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
	         pstmt.setString(1, user.getUser_nickname());
	         pstmt.setString(2, comments.getCm_text());
	         pstmt.setInt(3, user.getId_no());
	         pstmt.setInt(4, tmid);
	         i = pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return (i>0);
	   }



}
