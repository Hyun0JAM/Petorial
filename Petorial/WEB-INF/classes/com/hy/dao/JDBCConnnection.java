package com.hy.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnnection {
	private static Connection conn = null;
	   
	   public static Connection getConnection(){
	      if(conn==null){
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn=DriverManager.getConnection(
	                  "jdbc:mysql://localhost:3306/petorial",
	                  "root", "1234");
	         } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      return conn;
	   }
}
