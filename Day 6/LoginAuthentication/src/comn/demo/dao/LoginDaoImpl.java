package comn.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao {
	static Connection con;
	static PreparedStatement plogin;
	static {
		
		try {
			con=DBUtil.getMyConnection();
			plogin=con.prepareStatement("select * from user where uname=? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User validateUser(String uname, String pass) {
		try {
			plogin.setString(1,uname);
			plogin.setString(2, pass);
			ResultSet rs=plogin.executeQuery();
			if(rs.next()) {
				User u=new User(rs.getString(1),rs.getString(2),rs.getString(3));
				return u;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

}
