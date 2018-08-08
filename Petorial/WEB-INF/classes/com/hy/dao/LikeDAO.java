package com.hy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hy.dto.TagDTO;
import com.hy.dto.UserDTO;

public class LikeDAO {
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;

  // �빐�떦 寃뚯떆臾� Like �닔
  public int likeCount(int tm_no) {
    String sql = "SELECT COUNT(*) FROM like WHERE tm_no = ?";
    try {
			pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
			pstmt.setInt(1, tm_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
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
		return 0;
  }

  // 寃뚯떆臾� 醫뗭븘�슂 �늻瑜닿린
  public void likeOn(int id_no, int tm_no) {
    String sql = "INSERT INTO likes(id_no,tm_no) VALUES(?,?)";
    int i=0;
    try {
        pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id_no);
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
  }

  // 寃뚯떆臾� 醫뗭븘�슂 痍⑥냼
  public void likeOff(int id_no, int tm_no) {
    String sql = "DELETE FROM likes WHERE id_no=? AND tm_no=?";
    int i=0;
    try {
        pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id_no);
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
    
  }

  // �빐�떦 寃뚯떆臾� 醫뗭븘�슂�븳 �궗�엺紐⑸줉
  public List<UserDTO> getLikeOnList(int tm_no) {
    String sql = "SELECT * FROM user_info WHERE id_no IN (SELECT id_no FROM likes WHERE tm_no=?)";
    List<UserDTO> list = null;
    try {
        pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, tm_no);
        rs = pstmt.executeQuery();
        list = new ArrayList<UserDTO>();
        while(rs.next()) {
        	UserDTO user = new UserDTO();
        	user.setId_no(rs.getInt("id_no"));
			user.setUser_email(rs.getString("user_email"));
			user.setUser_pw(rs.getString("user_pw"));
			user.setUser_birth(rs.getInt("user_birth"));
			user.setUser_nickname(rs.getString("user_nickname"));
			user.setUser_img(rs.getString("user_img"));
        	list.add(user);
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
    return list;
  }

  // �빐�떦 寃뚯떆臾� 醫뗭븘�슂�븳 �뿬遺�
  public boolean likeCheck(int id_no, int tm_no) {
    String sql = "SELECT id_no FROM likes WHERE tm_no = ?";
    try {
        pstmt = JDBCConnnection.getConnection().prepareStatement(sql);
        pstmt.setInt(1, tm_no);
        rs = pstmt.executeQuery();

        while(rs.next()) {
        	if(rs.getInt("id_no")==id_no) {return false;}
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
    return true;
  }







}
