package com.hy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hy.dto.PhotoDTO;

public class PhotoDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;

	// tag寃��깋�떆 �빐�떦 photo 媛앹껜 遺덈윭�삤湲�
	public List<PhotoDTO> getSearchPhoto(String tag) {
		String sql = "SELECT * FROM timeline WHERE tm_no IN (SELECT tm_no FROM tag WHERE tg_tag LIKE CONCAT('%',?,'%'))";
		List<PhotoDTO> list = null;
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, tag);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				PhotoDTO photo = new PhotoDTO();
				photo.setTm_no(rs.getInt("tm_no"));
				photo.setTm_content(rs.getString("tm_content"));
				photo.setTm_img(rs.getString("tm_img"));
				photo.setTm_nick(rs.getString("tm_nick"));
				photo.setTm_userimg(rs.getString("tm_userimg"));
				list.add(photo);
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

	// 紐⑤뱺 phto 媛앹껜 遺덈윭�삤湲�
	public List<PhotoDTO> getPhoto() {
		String sql = "SELECT * FROM timeline";
		List<PhotoDTO> list = null;
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				PhotoDTO photo = new PhotoDTO();
				photo.setTm_no(rs.getInt("tm_no"));
				photo.setTm_content(rs.getString("tm_content"));
				photo.setTm_img(rs.getString("tm_img"));
				photo.setTm_nick(rs.getString("tm_nick"));
				photo.setTm_userimg(rs.getString("tm_userimg"));
				list.add(photo);
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

	// 留덉�留� 寃뚯떆臾� 踰덊샇
	public int getTmno() {
		String sql = "SELECT MAX(tm_no) FROM TIMELINE";
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 寃뚯떆臾� �벐湲�
	public boolean writePhoto(PhotoDTO photo) {
		String sql = "INSERT INTO timeline(tm_nick, tm_content, tm_userimg, tm_img,id_no) VALUES(?,?,?,?,?)";
	      int i = 0;
	      try {
	         pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
	         pstmt.setString(1, photo.getTm_nick());
	         pstmt.setString(2, photo.getTm_content());
	         pstmt.setString(3, photo.getTm_userimg());
	         pstmt.setString(4, photo.getTm_img());
	         pstmt.setInt(5, photo.getId_no());
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

	// user 寃뚯떆臾� 遺덈윭�삤湲�
	public List<PhotoDTO> getUserPhoto(int id_no) {
		String sql = "SELECT * FROM timeline WHERE id_no=?";
		List<PhotoDTO> list = null;
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setInt(1, id_no);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				PhotoDTO photo = new PhotoDTO();
				photo.setId_no(rs.getInt("id_no"));
				photo.setTm_no(rs.getInt("tm_no"));
				photo.setTm_content(rs.getString("tm_content"));
				photo.setTm_img(rs.getString("tm_img"));
				photo.setTm_nick(rs.getString("tm_nick"));
				photo.setTm_userimg(rs.getString("tm_userimg"));
				list.add(photo);
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


}
