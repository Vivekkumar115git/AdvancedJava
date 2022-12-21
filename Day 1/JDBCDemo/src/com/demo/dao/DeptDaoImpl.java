package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Department;

public class DeptDaoImpl implements DeptDao {
	static Connection con;
	static PreparedStatement pins,psel,pselbyId,pdelbyId,pupbyId;
	static {
		 
		 try {
			 con=DBUtil.getMyConnection();
			 pins=con.prepareStatement("insert into dept values(?,?,?)");
		     psel=con.prepareStatement("select * from dept");
		     pselbyId=con.prepareStatement("select * from dept where deptno=?");
		     pdelbyId=con.prepareStatement("delete from dept where deptno=?");
		     pupbyId=con.prepareStatement("update dept set dname=?,loc=? where deptno=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void closeMyConnction() {
		DBUtil.closeMyConnection();
		
	}
	@Override
	public void insertNewDepartment(Department d) {
		try {
			
			pins.setInt(1,d.getDeptid());
			pins.setString(2, d.getDname());
			pins.setString(3, d.getLoc());
			int n=pins.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Department> findAll() {
		try {
			
			ResultSet rs=psel.executeQuery();
			List<Department> dlist=new ArrayList<>();
			while(rs.next()) {
				dlist.add(new Department(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			if(dlist.size()>0) {
				return dlist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Department findById(int id) {
		
		try {
			pselbyId.setInt(1, id);
			ResultSet rs=pselbyId.executeQuery();
			if(rs.next())
			{
				return new Department(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public boolean removebyId(int id) {
		
		try {
			pdelbyId.setInt(1, id);
			int n=pdelbyId.executeUpdate();
			if(n>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updatebyId(int id, String nm, String loc) {
		
		try {
			pupbyId.setString(1, nm);
			pupbyId.setString(2, loc);
			pupbyId.setInt(3, id);
			int n=pupbyId.executeUpdate();
			if(n>0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
