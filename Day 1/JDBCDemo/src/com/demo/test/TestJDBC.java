package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) {
		Connection con=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://localhost:3306/test?useSSL=false";
			String username="root";
			String password="root123";
			 con=DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from dept" );
			while(rs.next()) {
				System.out.println("Deptno: "+rs.getInt(1));
				System.out.println("Dname : "+rs.getString(2));
				System.out.println("Location : "+rs.getString(3));
				System.out.println("------------------------");
			}
			
			//insert data in the table
			int id=34;
			String nm="admin";
			String loc="Mumbai";
			String query="insert into dept values("+id+",'"+nm+"','"+loc+"')";
			System.out.println(query);
			int n=st.executeUpdate(query);
			if (n>0) {
				System.out.println("inserted successfully");
			}
			con.commit();
			rs=st.executeQuery("select * from dept" );
			while(rs.next()) {
				System.out.println("Deptno: "+rs.getInt(1));
				System.out.println("Dname : "+rs.getString(2));
				System.out.println("Location : "+rs.getString(3));
				System.out.println("------------------------");
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
