package com.demo.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CallableStatementDemo {
	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
			String username="root";
			String password="root123";
			Connection con=DriverManager.getConnection(url,username,password);
			CallableStatement cst=con.prepareCall("{call getcnt(?,?)}");
			int id=10;
			cst.setInt(1, id);
			cst.registerOutParameter(2, java.sql.Types.INTEGER);
			cst.execute();
			int cnt=cst.getInt(2);
			System.out.println("number of employees in deptno : 10 -->"+cnt);
			
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
