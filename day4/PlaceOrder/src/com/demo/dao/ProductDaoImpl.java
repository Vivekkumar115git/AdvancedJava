package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	static Connection con;
	static PreparedStatement pselByCatid;
	static {
		
		try {
			con=DBUtil.getMyConnection();
			pselByCatid=con.prepareStatement("select * from product where cid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public List<Product> getByCategory(int catid) {
		try {
			List<Product> plist=new ArrayList<>();
			pselByCatid.setInt(1, catid);
			ResultSet rs=pselByCatid.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
			}
			if(plist.size()>0)
			   return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
