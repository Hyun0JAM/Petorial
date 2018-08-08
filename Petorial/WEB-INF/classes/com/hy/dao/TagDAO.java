package com.hy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hy.dto.TagDTO;

public class TagDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;

	// tag 저장
	public boolean insert(int tm_no, String tg_tag) {
		String sql = "INSERT INTO tag(tg_tag,tm_no) VALUES(?,?)";
		int i = 0;
	      try {
	         pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
	         pstmt.setString(1, tg_tag);
	         pstmt.setInt(2, tm_no);
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

	// 해당 게시물의 태그 불러오기
	public List<TagDTO> getTag(int tm_no) {
		String sql = "SELECT * FROM tag WHERE tm_no=?";
		List<TagDTO> tags= null;
	      try {
	        pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
	        pstmt.setInt(1, tm_no);
	        rs = pstmt.executeQuery();

	        tags = new ArrayList<TagDTO>();
	        while(rs.next()) {
	    		TagDTO tag = new TagDTO();
	        	tag.setTg_no(rs.getInt("tg_no"));
	        	tag.setTg_tag(rs.getString("tg_tag"));
	        	tag.setTm_no(rs.getInt("tm_no"));
	        	tags.add(tag);
	        }
		}
		catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            pstmt.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return tags;
	}
}
