package com.hy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hy.dto.UserDTO;

public class UserDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;

	// DB �젙蹂� 媛앹껜�뿉 ���옣�븯湲�
	public UserDTO getUserInfo(UserDTO user) {
		String sql = "SELECT * FROM user_info WHERE user_email = ?";
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUser_email());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setId_no(rs.getInt("id_no"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setUser_birth(rs.getInt("user_birth"));
				user.setUser_nickname(rs.getString("user_nickname"));
				user.setUser_img(rs.getString("user_img"));
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
		return user;
	}

	// 濡쒓렇�씤 �븯湲�
	public String loginCheck(UserDTO user) {
		String sql = "SELECT user_pw FROM user_info WHERE user_email = ?";
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUser_email());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(user.getUser_pw().equals(rs.getString("user_pw"))) {
					return "DONE";
				} else {
					return "WRONG PASSWORD";
				}
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
		return "NO EMAIL";
	}

	// �쉶�썝媛��엯 �븯湲�
	public boolean setUserInfo(UserDTO user){
	      String sql = "INSERT INTO user_info("
	            + "user_email, user_pw, user_img, user_birth, user_nickname) "
	            + "VALUES(?,?,?,?,?)";
	      int i = 0;
	      try {
	         pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
	         pstmt.setString(1, user.getUser_email());
	         pstmt.setString(2, user.getUser_pw());
	         pstmt.setString(3, user.getUser_img());
	         pstmt.setInt(4, user.getUser_birth());
	         pstmt.setString(5, user.getUser_nickname());
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

	// �쉶�썝 �젙蹂� �닔�젙
	public boolean modUserInfo(UserDTO user){
	      String sql = "UPDATE user_info SET"
	            + "user_email=?, user_pw=?, user_img=?, user_birth=?, user_nickname=?"
	            + "WHERE id_no=?";
	      int i = 0;
	      try {
	         pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
	         pstmt.setString(1, user.getUser_email());
	         pstmt.setString(2, user.getUser_pw());
	         pstmt.setString(3, user.getUser_img());
	         pstmt.setInt(4, user.getUser_birth());
	         pstmt.setString(5, user.getUser_nickname());
					 pstmt.setInt(6, user.getId_no());
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

	// EMAIL 以묐났 泥댄겕�븯湲�
	public boolean emailCheck(UserDTO user) {
		String sql = "SELECT * FROM user_info WHERE user_email = ?";
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUser_email());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// EMAIL 以묐났 �솗�씤
				return true;
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
		return false;
	}

	// userid濡� DB�젙蹂� 遺덈윭�삤湲�
	public UserDTO userInfoWithId(UserDTO user) {
		String sql = "SELECT * FROM user_info WHERE id_no = ?";
		try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setInt(1, user.getId_no());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setId_no(rs.getInt("id_no"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_pw(rs.getString("user_pw"));
				user.setUser_birth(rs.getInt("user_birth"));
				user.setUser_nickname(rs.getString("user_nickname"));
				user.setUser_img(rs.getString("user_img"));
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
		return user;
	}
}
